import java.util.*;

public class QuadrupleGenerator {
    // Pilas y cola
    private Stack<String> operandStack  = new Stack<>();
    private Stack<String> operatorStack = new Stack<>();
    private Stack<String> typeStack     = new Stack<>();
    private Queue<Cuadruplo> quads      = new LinkedList<>();
    private int tempCount = 0;

    // 1) Push de operando + tipo
    public void pushOperand(String operand, String type) {
        operandStack.push(operand);
        typeStack.push(type);
    }

    // 2) Push de operador
    public void pushOperator(String op) {
        operatorStack.push(op);
    }

    // 3) Genera cuádruplo binario (aritmético o relacional)
    public void generateBinaryQuad() {
        String arg2 = operandStack.pop(), t2 = typeStack.pop();
        String arg1 = operandStack.pop(), t1 = typeStack.pop();
        String op   = operatorStack.pop();
        // determinamos tipo de resultado
        String resType = (t1.equals("float")||t2.equals("float")) ? "float" : "int";
        String tmp = "t" + (tempCount++);
        // apilamos temporal
        operandStack.push(tmp);
        typeStack.push(resType);
        // guardamos cuadruplo
        quads.add(new Cuadruplo(op, arg1, arg2, tmp));
    }

    // 4) Asignación: (=, valor, -, varName)
    public void generateAssignment(String varName) {
        String val = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("=", val, "-", varName));
    }

    // 5) PRINT: (PRINT, valor, -, -)
    public void generatePrint() {
        String val = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("PRINT", val, "-", "-"));
    }

    // 6) Obtener lista final
    public List<Cuadruplo> getQuadruples() {
        return new ArrayList<>(quads);
    }

    // 7) Desplegar en consola
    public void printQuadruples() {
        System.out.println("\n--- Cuádruplos Generados ---");
        int i = 0;
        for (Cuadruplo q : quads) {
            System.out.printf("%2d: %s%n", i++, q);
        }
    }
}
