import java.util.*;

public class QuadrupleGenerator {
    private final VirtualMemoryManager vmm = new VirtualMemoryManager();
    private final Stack<String> operandStack  = new Stack<>();
    private final Stack<String> typeStack     = new Stack<>();
    private final Stack<String> operatorStack = new Stack<>();
    private final Queue<Cuadruplo> quads       = new LinkedList<>();
    private int tempCount = 0;
    private int labelCount = 0;

    /** Push a literal or variable name onto the operand stack. */
    public void pushOperand(String operand, String type) {
        operandStack.push(operand);
        typeStack.push(type);
    }

    /** Push a virtual address directly onto the operand stack. */
    public void pushOperandAddress(int address, String type) {
        operandStack.push(Integer.toString(address));
        typeStack.push(type);
    }

    /** Push an operator onto the operator stack. */
    public void pushOperator(String op) {
        operatorStack.push(op);
    }

    /** Generate a binary operation quadruple. */
    public void generateBinaryQuad() {
        String arg2 = operandStack.pop(); String t2 = typeStack.pop();
        String arg1 = operandStack.pop(); String t1 = typeStack.pop();
        String op   = operatorStack.pop();
        String resType = (t1.equals("float") || t2.equals("float")) ? "float" : "int";
        // Allocate temporary
        int tempAddr = vmm.allocTemp(resType);
        operandStack.push(Integer.toString(tempAddr));
        typeStack.push(resType);
        quads.add(new Cuadruplo(op, arg1, arg2, Integer.toString(tempAddr)));
    }

    /** Generate an assignment quadruple using the destination address. */
    public void generateAssignmentAddress(int destAddr) {
        String val = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("=", val, "-", Integer.toString(destAddr)));
    }

    /** Legacy: generates assignment by variable name (not recommended for VM execution). */
    public void generateAssignment(String varName) {
        String val = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("=", val, "-", varName));
    }

    /** Generate a PRINT quadruple for numeric expressions. */
    public void generatePrint() {
        String val = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("PRINT", val, "-", "-"));
    }

    /** Generate a PRINT_STR quadruple for string literals. */
    public void generatePrintString(String text) {
        quads.add(new Cuadruplo("PRINT_STR", text, "-", "-"));
    }

    /** Generate a PARAM quadruple for function call arguments. */
    public void generateParam() {
        String arg = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("PARAM", arg, "-", "-"));
    }

    /** Generate an ERA quadruple to prepare a function activation record. */
    public void generateERA(String funcName) {
        quads.add(new Cuadruplo("ERA", funcName, "-", "-"));
    }

    /** Generate a GOSUB quadruple to jump to the function. */
    public void generateGOSUB(String funcName) {
        quads.add(new Cuadruplo("GOSUB", funcName, "-", "-"));
    }

    /** Generate a LABEL quadruple marking the start of a function. */
    public void generateFuncBegin(String funcName) {
        quads.add(new Cuadruplo("LABEL", "-", "-", funcName));
    }

    /** Generate an ENDPROC quadruple marking the end of a function. */
    public void generateFuncEnd() {
        quads.add(new Cuadruplo("ENDPROC", "-", "-", "-"));
    }

    /** Generate a GOTO quadruple for unconditional jumps. */
    public void generateGoto(String label) {
        quads.add(new Cuadruplo("GOTO", "-", "-", label));
    }

    /** Generate a GOTOF quadruple for conditional false jumps. */
    public void generateGotoF(String condTemp, String label) {
        quads.add(new Cuadruplo("GOTOF", condTemp, "-", label));
    }

    /** Create and return a new unique label. */
    public String newLabel() {
        return "L" + (labelCount++);
    }

    /** Mark a position in code with a LABEL quadruple. */
    public void markLabel(String label) {
        quads.add(new Cuadruplo("LABEL", "-", "-", label));
    }

    /** Peek at the top operand without popping it. */
    public String peekOperand() {
        return operandStack.peek();
    }

    /** Retrieve all generated quadruples as a list. */
    public List<Cuadruplo> getQuadruples() {
        return new ArrayList<>(quads);
    }

    /** Print all generated quadruples to the console. */
    public void printQuadruples() {
        System.out.println("\n--- Cuádruplos Generados ---");
        int i = 0;
        for (Cuadruplo q : quads) {
            System.out.printf("%2d: %s%n", i++, q);
        }
    }
}
