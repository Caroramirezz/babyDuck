import java.util.*;

public class QuadrupleGenerator {
    // Gestión de memoria virtual
    private final VirtualMemoryManager vmm = new VirtualMemoryManager();
    private int labelCount = 0;

    // Pilas para operandos (stored as String addresses), tipos y operadores
    private final Stack<String> operandStack  = new Stack<>();
    private final Stack<String> typeStack     = new Stack<>();
    private final Stack<String> operatorStack = new Stack<>();

    // Cola FIFO para almacenar los cuádruplos
    private final Queue<Cuadruplo> quads = new LinkedList<>();

    // Contador para temporales (nombres t0, t1, …)
    private int tempCount = 0;

    /** Inserta un operando literal o variable (como texto) */
    public void pushOperand(String operand, String type) {
        operandStack.push(operand);
        typeStack.push(type);
    }

    /** Inserta un operando dando directamente su dirección virtual */
    public void pushOperandAddress(int address, String type) {
        operandStack.push(Integer.toString(address));
        typeStack.push(type);
    }

    /** Inserta un operador (+, -, *, /, <, >, !=) */
    public void pushOperator(String op) {
        operatorStack.push(op);
    }

    /**
     * Genera un cuádruplo para la operación binaria
     * (toma dos operandos y un operador de las pilas).
     */
    public void generateBinaryQuad() {
        // Pop de operandos y tipos
        String arg2   = operandStack.pop(); String t2 = typeStack.pop();
        String arg1   = operandStack.pop(); String t1 = typeStack.pop();
        String op     = operatorStack.pop();

        // Determinar tipo de resultado
        String resType = (t1.equals("float") || t2.equals("float")) ? "float" : "int";

        // Asignar nuevo temporal y su dirección
        String tempName = "t" + (tempCount++);
        int    tempAddr = vmm.allocTemp(resType);

        // Empujar dirección y tipo del temporal para cálculos posteriores
        operandStack.push(Integer.toString(tempAddr));
        typeStack.push(resType);

        // Crear y encolar el cuádruplo
        quads.add(new Cuadruplo(op, arg1, arg2, Integer.toString(tempAddr)));
    }

    /**
     * Genera un cuádruplo de asignación:
     *   (=, valor, -, nombreVariable)
     */
    public void generateAssignment(String varName) {
        String val = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("=", val, "-", varName));
    }

    /**
     * Genera un cuádruplo de PRINT para un solo valor:
     *   (PRINT, valor, -, -)
     */
    public void generatePrint() {
        String val = operandStack.pop();
        typeStack.pop();
        quads.add(new Cuadruplo("PRINT", val, "-", "-"));
    }

    /** Devuelve la lista de cuádruplos generados */
    public List<Cuadruplo> getQuadruples() {
        return new ArrayList<>(quads);
    }

/** Crea una nueva etiqueta: L0, L1, … */
    public String newLabel() {
        return "L" + (labelCount++);
    }

    /** Marca una etiqueta en la cola de cuádruplos */
    public void markLabel(String label) {
        quads.add(new Cuadruplo("LABEL", "-", "-", label));
    }

    /** GOTO incondicional */
    public void generateGoto(String label) {
        quads.add(new Cuadruplo("GOTO", "-", "-", label));
    }

    /** GOTO si la condición es falsa */
    public void generateGotoF(String conditionTemp, String label) {
        quads.add(new Cuadruplo("GOTOF", conditionTemp, "-", label));
    }

    /** Devuelve el tope actual de operandos (usado para recuperar el temporal con la condición) */
    public String peekOperand() {
        return operandStack.peek();
    }


    /** Imprime en consola todos los cuádruplos encolados */
    public void printQuadruples() {
        System.out.println("\n--- Cuádruplos Generados ---");
        int i = 0;
        for (Cuadruplo q : quads) {
            System.out.printf("%2d: %s%n", i++, q);
        }
    }
}
