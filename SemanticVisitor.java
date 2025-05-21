import org.antlr.v4.runtime.tree.TerminalNode;

public class SemanticVisitor extends BabyDuckBaseVisitor<Void> {
    private final FunctionDirectory dir = new FunctionDirectory();
    private final QuadrupleGenerator qg = new QuadrupleGenerator();
    private final VirtualMemoryManager vmm = new VirtualMemoryManager();


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
    // Si este nodo no corresponde a VAR ... SEMICOLON vars, lo ignoramos
    if (ctx.VAR() == null) {
        return null;
    }

    // Ahora sí seguro hay type(), ID(), listaIds() y SEMICOLON
    String type = ctx.type().getText();

    // Primera variable de la línea
    int addr0 = vmm.allocGlobal(type);
    String id0 = ctx.ID().getText();
    dir.addVariableToCurrent(id0, type, addr0);

    // Variables adicionales
    for (TerminalNode idNode : ctx.listaIds().ID()) {
        int addr = vmm.allocGlobal(type);
        String id = idNode.getText();
        dir.addVariableToCurrent(id, type, addr);
    }

    // Recurre para la siguiente vars (si existe)
    if (ctx.vars() != null) {
        visit(ctx.vars());
    }
    return null;
}


@Override
public Void visitCycle_stmt(BabyDuckParser.Cycle_stmtContext ctx) {
    // 1) Etiqueta de inicio del while
    String startLabel = qg.newLabel();
    qg.markLabel(startLabel);

    // 2) Evaluar la condición
    visit(ctx.expresion());                       // genera el cuadruplo relacional
    String condTemp = qg.peekOperand();            // recupera el temporal de la condición

    // 3) Prepara etiqueta de salida
    String endLabel = qg.newLabel();
    qg.generateGotoF(condTemp, endLabel);         // GOTOF condTemp -> endLabel

    // 4) Cuerpo del bucle
    visit(ctx.body());

    // 5) Salto incondicional al inicio
    qg.generateGoto(startLabel);

    // 6) Marca el fin del bucle
    qg.markLabel(endLabel);
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
    // 1) Literal entero
    if (ctx.CTE_INT() != null) {
        String text = ctx.CTE_INT().getText();
        int addr    = vmm.allocConst(text, "int");
        qg.pushOperandAddress(addr, "int");
        return null;
    }
    // 2) Literal float
    if (ctx.CTE_FLOAT() != null) {
        String text = ctx.CTE_FLOAT().getText();
        int addr    = vmm.allocConst(text, "float");
        qg.pushOperandAddress(addr, "float");
        return null;
    }
    // 3) Literal string
    if (ctx.CTE_STRING() != null) {
        String text = ctx.CTE_STRING().getText();
        // si quieres asignar direcciones a strings, hazlo aquí
        qg.pushOperand(text, "string");
        return null;
    }
    // 4) Identificador
    if (ctx.ID() != null) {
        String id = ctx.ID().getText();
        // Validación de existencia
        boolean exists = dir.getFunction(dir.currentFunction).getVariable(id) != null
                      || dir.getFunction("global").getVariable(id) != null;
        if (!exists) throw new RuntimeException("Variable no declarada: " + id);
        // Recuperar su dirección
        VariableInfo info = dir.getFunction(dir.currentFunction).getVariable(id);
        if (info == null) info = dir.getFunction("global").getVariable(id);
        int addr = info.address;
        qg.pushOperandAddress(addr, info.type);
        return null;
    }
    // 5) Subexpresión entre paréntesis
    if (ctx.LPAREN() != null) {
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
