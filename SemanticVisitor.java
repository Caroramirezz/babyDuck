import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;

public class SemanticVisitor extends BabyDuckBaseVisitor<Void> {
    private final FunctionDirectory dir = new FunctionDirectory();
    private final QuadrupleGenerator qg = new QuadrupleGenerator();
    private final VirtualMemoryManager vmm = new VirtualMemoryManager();

    public SemanticVisitor() {
        // Contexto global
        dir.addFunction("global", "void");
        dir.setCurrentFunction("global");
    }

    public FunctionDirectory getFunctionDirectory() { return dir; }
    public QuadrupleGenerator getQuadGenerator()    { return qg;  }
    public VirtualMemoryManager getVirtualMemoryManager() { return vmm; }

    @Override
    public Void visitPrograma(BabyDuckParser.ProgramaContext ctx) {
        // Visitar vars, funcs y body en orden
        visit(ctx.vars());

        
        visit(ctx.funcs());
        visit(ctx.body());
        return null;
    }

    @Override
    public Void visitVars(BabyDuckParser.VarsContext ctx) {
        // vars : ( VAR idList COLON type SEMICOLON )* ;
        if (ctx.VAR().isEmpty()) return null;
        List<BabyDuckParser.IdListContext> lists = ctx.idList();
        List<BabyDuckParser.TypeContext>     types = ctx.type();
        for (int i = 0; i < lists.size(); i++) {
            String ty = types.get(i).getText();
            for (TerminalNode idNode : lists.get(i).ID()) {
                String id = idNode.getText();
                int addr = vmm.allocGlobal(ty);
                dir.addVariableToCurrent(id, ty, addr);
            }
        }
        return null;
    }

    @Override
    public Void visitFuncs(BabyDuckParser.FuncsContext ctx) {
        // funcs : ( VOID ID LPAREN paramList? RPAREN vars body SEMICOLON )* ;
        List<TerminalNode> voids = ctx.VOID();
        for (int i = 0; i < voids.size(); i++) {
            String fname = ctx.ID(i).getText();            
            // Generar etiqueta de inicio de función
            //qg.generateFuncBegin(fname);
            dir.addFunction(fname, "void");
            dir.setCurrentFunction(fname);

            // Parámetros formales si existen
            if (ctx.paramList(i) != null) {
                BabyDuckParser.ParamListContext p = ctx.paramList(i);
                for (int j = 0; j < p.ID().size(); j++) {
                    String pname = p.ID(j).getText();
                    String ptype = p.type(j).getText();
                    int paddr = vmm.allocLocal(ptype);
                    dir.addVariableToCurrent(pname, ptype, paddr);
                    dir.getFunction(fname).addParamType(ptype);
                }
            }

            // Variables locales y cuerpo de la función
            visit(ctx.vars(i));
            visit(ctx.body(i));

            // Fin de la función
            qg.generateFuncEnd();
            dir.setCurrentFunction("global");
        }
        return null;
    }

    @Override
    public Void visitAssign(BabyDuckParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        VariableInfo vi = dir.getFunction(dir.currentFunction).getVariable(id);
        if (vi == null) vi = dir.getFunction("global").getVariable(id);
        if (vi == null) throw new RuntimeException("Variable no declarada: " + id);
        visit(ctx.expresion());
        qg.generateAssignmentAddress(vi.address);
        return null;
    }

    @Override
    public Void visitPrint(BabyDuckParser.PrintContext ctx) {
        for (BabyDuckParser.ExpresionContext e : ctx.expresion()) {
            visit(e);
            qg.generatePrint();
        }
        for (TerminalNode s : ctx.CTE_STRING()) {
            qg.generatePrintString(s.getText());
        }
        return null;
    }

    @Override
    public Void visitCondition(BabyDuckParser.ConditionContext ctx) {
        visit(ctx.expresion());
        String cond = qg.peekOperand();
        String Lf   = qg.newLabel();
        qg.generateGotoF(cond, Lf);
        visit(ctx.body(0));
        if (ctx.ELSE() != null) {
            String Le = qg.newLabel();
            qg.generateGoto(Le);
            qg.markLabel(Lf);
            visit(ctx.body(1));
            qg.markLabel(Le);
        } else {
            qg.markLabel(Lf);
        }
        return null;
    }

    @Override
    public Void visitCycle(BabyDuckParser.CycleContext ctx) {
        String start = qg.newLabel();
        qg.markLabel(start);
        visit(ctx.expresion());
        String cond = qg.peekOperand();
        String end   = qg.newLabel();
        qg.generateGotoF(cond, end);
        visit(ctx.body());
        qg.generateGoto(start);
        qg.markLabel(end);
        return null;
    }

    @Override
    public Void visitF_call(BabyDuckParser.F_callContext ctx) {
        String fname = ctx.ID().getText();
        // Preparar ERA
        qg.generateERA(fname);
        if (ctx.expresion() != null) {
            for (BabyDuckParser.ExpresionContext e : ctx.expresion()) {
                visit(e);
                qg.generateParam();
            }
        }
        // Generar llamada
        qg.generateGOSUB(fname);
        return null;
    }

    @Override
    public Void visitExpresion(BabyDuckParser.ExpresionContext ctx) {
        visit(ctx.exp(0));
        if (ctx.oprel() != null) {
            qg.pushOperator(ctx.oprel().getText());
            visit(ctx.exp(1));
            qg.generateBinaryQuad();
        }
        return null;
    }

    @Override
    public Void visitExp(BabyDuckParser.ExpContext ctx) {
        visit(ctx.termino(0));
        for (int i = 1; i < ctx.termino().size(); i++) {
            String op = ctx.getChild(2*i-1).getText();
            qg.pushOperator(op);
            visit(ctx.termino(i));
            qg.generateBinaryQuad();
        }
        return null;
    }

    @Override
    public Void visitTermino(BabyDuckParser.TerminoContext ctx) {
        visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            String op = ctx.getChild(2*i-1).getText();
            qg.pushOperator(op);
            visit(ctx.factor(i));
            qg.generateBinaryQuad();
        }
        return null;
    }

    @Override
    public Void visitFactor(BabyDuckParser.FactorContext ctx) {
        if (ctx.LPAREN() != null) {
            visit(ctx.expresion());
        } else if (ctx.cte() != null) {
            String val = ctx.cte().getText();
            String ty  = ctx.cte().CTE_INT() != null ? "int" : "float";
            int addr   = vmm.allocConst(val, ty);
            qg.pushOperandAddress(addr, ty);
        } else {
            String id = ctx.ID().getText();
            VariableInfo vi = dir.getFunction(dir.currentFunction).getVariable(id);
            if (vi == null) vi = dir.getFunction("global").getVariable(id);
            if (vi == null) throw new RuntimeException("Variable no declarada: " + id);
            qg.pushOperandAddress(vi.address, vi.type);
        }
        return null;
    }
}
