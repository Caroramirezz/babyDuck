import java.util.*;

public class VirtualMachine {
    private final VirtualMemoryManager vmm;
    private final Map<Integer,Object> memory;
    private final Map<String,Integer> labelMap = new HashMap<>();

    public VirtualMachine(VirtualMemoryManager vmm) {
        this.vmm    = vmm;
        this.memory = new HashMap<>();
    }

    public void loadConstants() {
        for (Map.Entry<String,Integer> e : vmm.getConstTable().entrySet()) {
            String[] parts = e.getKey().split(":"); // "int:5" o "float:2.3"
            Object val = parts[0].equals("int")
                       ? Integer.parseInt(parts[1])
                       : Float.parseFloat(parts[1]);
            memory.put(e.getValue(), val);
        }
    }

    public void run(List<Cuadruplo> quads) {
        // Primera pasada: registrar etiquetas
        for (int i = 0; i < quads.size(); i++) {
            Cuadruplo q = quads.get(i);
            if ("LABEL".equals(q.getOp())) {
                labelMap.put(q.getRes(), i);
            }
        }

        int pc = 0;
        while (pc < quads.size()) {
            Cuadruplo q = quads.get(pc);
            String op  = q.getOp();
            String a1  = q.getArg1();
            String a2  = q.getArg2();
            String res = q.getRes();

            switch (op) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "<":
                case ">":
                case "!=": {
                    Number v1 = (Number) memory.get(Integer.parseInt(a1));
                    Number v2 = (Number) memory.get(Integer.parseInt(a2));
                    Number out = compute(op, v1, v2);
                    memory.put(Integer.parseInt(res), out);
                    pc++;
                    break;
                }
                case "=": {
                    Number val = (Number) memory.get(Integer.parseInt(a1));
                    memory.put(Integer.parseInt(res), val);
                    pc++;
                    break;
                }
                case "PRINT": {
                    int addr = Integer.parseInt(a1);
                    Number val = (Number) memory.get(addr);
                    if (isIntAddress(addr)) {
                        // Si es una dirección de int, imprimir como int
                        System.out.println(val.intValue());
                    } else {
                        System.out.println(val);
                    }
                    pc++;
                    break;
                }
                case "PRINT_STR": {
                    // literal string con comillas
                    String text = a1;
                    if (text.length() >= 2 && 
                        text.charAt(0) == '"' && text.charAt(text.length()-1) == '"') {
                        text = text.substring(1, text.length()-1);
                    }
                    System.out.println(text);
                    pc++;
                    break;
                }
                case "GOTO": {
                    pc = labelMap.get(res);
                    break;
                }
                case "GOTOF": {
                    Number cond = (Number) memory.get(Integer.parseInt(a1));
                    if (cond.intValue() == 0) {
                        pc = labelMap.get(res);
                    } else {
                        pc++;
                    }
                    break;
                }
                case "LABEL":
                    pc++;
                    break;
                default:
                    // ERA, PARAM, GOSUB, ENDPROC, etc.
                    pc++;
            }
        }
    }

    private Number compute(String op, Number n1, Number n2) {
        switch (op) {
            case "+":
                if (n1 instanceof Float || n2 instanceof Float) 
                    return n1.floatValue() + n2.floatValue();
                else 
                    return n1.intValue() + n2.intValue();
            case "-":
                if (n1 instanceof Float || n2 instanceof Float) 
                    return n1.floatValue() - n2.floatValue();
                else 
                    return n1.intValue() - n2.intValue();
            case "*":
                if (n1 instanceof Float || n2 instanceof Float) 
                    return n1.floatValue() * n2.floatValue();
                else 
                    return n1.intValue() * n2.intValue();
            case "/":
                if (n1 instanceof Float || n2 instanceof Float) 
                    return n1.floatValue() / n2.floatValue();
                else 
                    return n1.intValue() / n2.intValue();
            case "<":
                return (n1.floatValue() < n2.floatValue()) ? 1 : 0;
            case ">":
                return (n1.floatValue() > n2.floatValue()) ? 1 : 0;
            case "!=":
                return (n1.floatValue() != n2.floatValue()) ? 1 : 0;
            default:
                throw new RuntimeException("Operador desconocido: " + op);
        }
    }

    /** true si la dirección pertenece a dir INT. */
    private boolean isIntAddress(int addr) {
        return (addr >= 1000 && addr < 2000)  // global int
            || (addr >= 3000 && addr < 4000)  // local int
            || (addr >= 5000 && addr < 6000)  // temp int
            || (addr >= 7000 && addr < 8000); // const int
    }
}
