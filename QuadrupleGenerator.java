import java.util.*;

public class QuadrupleGenerator {
    private final VirtualMemoryManager vmm = new VirtualMemoryManager();
    private final Stack<String> operandStack  = new Stack<>();
    private final Stack<String> typeStack     = new Stack<>();
    private final Stack<String> operatorStack = new Stack<>();
    private final Queue<Cuadruplo> quads       = new LinkedList<>();
    private int tempCount = 0;
    private int labelCount = 0;

    public void pushOperand(String operand, String type) {
        operandStack.push(operand);
        typeStack.push(type);
    }

    public void pushOperandAddress(int address, String type) {
        operandStack.push(Integer.toString(address));
        typeStack.push(type);
    }

    public void pushOperator(String op) {
        operatorStack.push(op);
    }

    public void generateBinaryQuad() {
        String arg2 = operandStack.pop(); String t2 = typeStack.pop();
        String arg1 = operandStack.pop(); String t1 = typeStack.pop();
        String op   = operatorStack.pop();
        String resType = (t1.equals("float") || t2.equals("float")) ? "float" : "int";

        int tempAddr = vmm.allocTemp(resType);
        operandStack.push(Integer.toString(tempAddr));
        typeStack.push(resType);
        quads.add(new Cuadruplo(op, arg1, arg2, Integer.toString(tempAddr)));
    }

    public void generateAssignmentAddress(int destAddr) {
        String val = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("=", val, "-", Integer.toString(destAddr)));
    }

    public void generateAssignment(String varName) {
        String val = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("=", val, "-", varName));
    }

    public void generatePrint() {
        String val = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("PRINT", val, "-", "-"));
    }

    public void generatePrintString(String text) {
        quads.add(new Cuadruplo("PRINT_STR", text, "-", "-"));
    }

    public void generateParam() {
        String arg = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("PARAM", arg, "-", "-"));
    }

    public void generateERA(String funcName) {
        quads.add(new Cuadruplo("ERA", funcName, "-", "-"));
    }

    public void generateGOSUB(String funcName) {
        quads.add(new Cuadruplo("GOSUB", funcName, "-", "-"));
    }

    public void generateFuncBegin(String funcName) {
        quads.add(new Cuadruplo("LABEL", "-", "-", funcName));
    }

    public void generateFuncEnd() {
        quads.add(new Cuadruplo("ENDPROC", "-", "-", "-"));
    }

    public void generateGoto(String label) {
        quads.add(new Cuadruplo("GOTO", "-", "-", label));
    }

    public void generateGotoF(String condTemp, String label) {
        quads.add(new Cuadruplo("GOTOF", condTemp, "-", label));
    }

    public String newLabel() {
        return "L" + (labelCount++);
    }

    public void markLabel(String label) {
        quads.add(new Cuadruplo("LABEL", "-", "-", label));
    }

    public String peekOperand() {
        return operandStack.peek();
    }

    public List<Cuadruplo> getQuadruples() {
        return new ArrayList<>(quads);
    }

    public void printQuadruples() {
        System.out.println("\n--- Cuádruplos Generados ---");
        int i = 0;
        for (Cuadruplo q : quads) {
            System.out.printf("%2d: %s%n", i++, q);
        }
    }
}
