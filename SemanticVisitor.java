import org.antlr.v4.runtime.tree.TerminalNode;

public class SemanticVisitor extends BabyDuckBaseVisitor<Void> {
    private final FunctionDirectory dir = new FunctionDirectory();
    private final QuadrupleGenerator qg = new QuadrupleGenerator();

    public SemanticVisitor() {
        dir.addFunction("global", "void");
        dir.setCurrentFunction("global");
    }

    // Exponer el directorio y el generador para Main.java
    public FunctionDirectory getFunctionDirectory() {
        return dir;
    }

    public QuadrupleGenerator getQuadGenerator() {
        return qg;
    }

    @Override
    public Void visitPrograma(BabyDuckParser.ProgramaContext ctx) {
        // Visitar vars, funcs, body…
        super.visitPrograma(ctx);
        return null;
    }

    @Override
    public Void visitFuncs(BabyDuckParser.FuncsContext ctx) {
        if (ctx.ID() == null) {
            return null;
        }

        String funcName = ctx.ID().getText();
        if (!dir.addFunction(funcName, "void")) {
            throw new RuntimeException("Función duplicada: " + funcName);
        }
        dir.setCurrentFunction(funcName);

        if (ctx.vars() != null)
            visit(ctx.vars());
        visit(ctx.body());

        dir.setCurrentFunction("global");
        return null;
    }

    @Override
    public Void visitVars(BabyDuckParser.VarsContext ctx) {
        String type = ctx.type().getText();
        String id0 = ctx.ID().getText();
        if (!dir.addVariableToCurrent(id0, type, 0))
            throw new RuntimeException("Variable duplicada: " + id0);

        for (TerminalNode idNode : ctx.listaIds().ID()) {
            String id = idNode.getText();
            if (!dir.addVariableToCurrent(id, type, 0))
                throw new RuntimeException("Variable duplicada: " + id);
        }
        return null;
    }

    @Override
    public Void visitAssign_stmt(BabyDuckParser.Assign_stmtContext ctx) {
        // Validar existencia
        String id = ctx.ID().getText();
        boolean exists = dir.getFunction(dir.currentFunction).getVariable(id) != null
                || dir.getFunction("global").getVariable(id) != null;
        if (!exists)
            throw new RuntimeException("Variable no declarada: " + id);

        // Generar cuádruplo de asignación
        visit(ctx.expresion());
        qg.generateAssignment(id);
        return null;
    }

    @Override
    public Void visitFactor(BabyDuckParser.FactorContext ctx) {
        if (ctx.CTE_INT() != null) {
            qg.pushOperand(ctx.CTE_INT().getText(), "int");
        } else if (ctx.CTE_FLOAT() != null) {
            qg.pushOperand(ctx.CTE_FLOAT().getText(), "float");
        } else if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            boolean exists = dir.getFunction(dir.currentFunction).getVariable(id) != null
                    || dir.getFunction("global").getVariable(id) != null;
            if (!exists)
                throw new RuntimeException("Variable no declarada: " + id);

            // Obtener tipo real desde la tabla de símbolos
            String type = (dir.getFunction(dir.currentFunction).getVariable(id) != null)
                ? dir.getFunction(dir.currentFunction).getVariable(id).type
                : dir.getFunction("global").getVariable(id).type;

            qg.pushOperand(id, type);
        } else {
            visit(ctx.expresion());
        }
        return null;
    }

    @Override
    public Void visitExp(BabyDuckParser.ExpContext ctx) {
        visit(ctx.termino());
        visit(ctx.exp_tail());
        return null;
    }

    @Override
    public Void visitExp_tail(BabyDuckParser.Exp_tailContext ctx) {
        if (ctx.PLUS()  != null) qg.pushOperator("+");
        if (ctx.MINUS() != null) qg.pushOperator("-");
        if (ctx.termino() != null) {
            visit(ctx.termino());
            qg.generateBinaryQuad();
            visit(ctx.exp_tail());
        }
        return null;
    }

    @Override
    public Void visitTermino(BabyDuckParser.TerminoContext ctx) {
        visit(ctx.factor());
        visit(ctx.termino_tail());
        return null;
    }

    @Override
    public Void visitTermino_tail(BabyDuckParser.Termino_tailContext ctx) {
        if (ctx.TIMES()   != null) qg.pushOperator("*");
        if (ctx.DIVIDED() != null) qg.pushOperator("/");
        if (ctx.factor() != null) {
            visit(ctx.factor());
            qg.generateBinaryQuad();
            visit(ctx.termino_tail());
        }
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
    public Void visitPrint_stmt(BabyDuckParser.Print_stmtContext ctx) {
        visit(ctx.expresion());
        qg.generatePrint();
        if (ctx.print_list() != null) {
            for (BabyDuckParser.ExpresionContext e : ctx.print_list().expresion()) {
                visit(e);
                qg.generatePrint();
            }
        }
        return null;
    }
}
