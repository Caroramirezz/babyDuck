import java.util.*;

// Asume que VirtualMemoryManager tiene este método público para exponer la tabla de constantes:
//    public Map<String,Integer> getConstTable() { return Collections.unmodifiableMap(constTable); }

public class VirtualMachine {
    private final VirtualMemoryManager vmm;
    private final Map<Integer, Object> memory;

    public VirtualMachine(VirtualMemoryManager vmm) {
        this.vmm = vmm;
        this.memory = new HashMap<>();
    }

    /** Carga todas las constantes (constTable) en la memoria de ejecución. */
    public void loadConstants() {
        for (Map.Entry<String, Integer> e : vmm.getConstTable().entrySet()) {
            String key = e.getKey();      // p.ej. "int:5" o "float:2.3"
            int addr   = e.getValue();
            String[] parts = key.split(":");
            Object val;
            if (parts[0].equals("int")) {
                val = Integer.parseInt(parts[1]);
            } else {
                val = Float.parseFloat(parts[1]);
            }
            memory.put(addr, val);
        }
    }

    /**
     * Ejecuta la lista de cuádruplos.
     * Soporta: + - * /, =, PRINT
     * Ignora etiquetas, saltos y llamadas por ahora.
     */
    public void run(List<Cuadruplo> quads) {
        for (Cuadruplo q : quads) {
            String op  = q.getOp();
            String a1  = q.getArg1();
            String a2  = q.getArg2();
            String res = q.getRes();
            switch (op) {
                case "+":
                case "-":
                case "*":
                case "/": {
                    Number v1 = (Number)memory.get(Integer.parseInt(a1));
                    Number v2 = (Number)memory.get(Integer.parseInt(a2));
                    Number out = computeBinary(op, v1, v2);
                    memory.put(Integer.parseInt(res), out);
                    break;
                }
                case "=": {
                    Number val = (Number)memory.get(Integer.parseInt(a1));
                    memory.put(Integer.parseInt(res), val);
                    break;
                }
                case "PRINT": {
                    Object val = memory.get(Integer.parseInt(a1));
                    System.out.println(val);
                    break;
                }
                default:
                    // ERA, GOSUB, LABEL, ENDPROC, GOTO, GOTOF, etc. no se procesan aún
                    break;
            }
        }
    }

    /** Realiza la operación binaria, promoviendo a float si alguno de los operandos es float. */
    private Number computeBinary(String op, Number n1, Number n2) {
        boolean isFloat = (n1 instanceof Float) || (n2 instanceof Float);
        if (isFloat) {
            float f1 = n1.floatValue(), f2 = n2.floatValue();
            switch (op) {
                case "+": return f1 + f2;
                case "-": return f1 - f2;
                case "*": return f1 * f2;
                default:  return f1 / f2;
            }
        } else {
            int i1 = n1.intValue(), i2 = n2.intValue();
            switch (op) {
                case "+": return i1 + i2;
                case "-": return i1 - i2;
                case "*": return i1 * i2;
                default:  return i1 / i2;
            }
        }
    }
}
