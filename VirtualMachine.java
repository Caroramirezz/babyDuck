import java.util.*;

public class VirtualMachine {
    private final FunctionDirectory dir;
    private final VirtualMemoryManager vmm;
    private final Map<Integer, Object> memory;
    private final Map<String, Integer> labelMap = new HashMap<>();
    private final Stack<Integer> returnStack = new Stack<>();
    private final List<Object> pendingParams = new ArrayList<>();
    private final Stack<Map<Integer, Object>> localStack = new Stack<>();
    private final Stack<Map<Integer, Object>> tempStack = new Stack<>();

    private Map<Integer, Object> localMemory = new HashMap<>();
    private Map<Integer, Object> tempMemory = new HashMap<>();

    public VirtualMachine(VirtualMemoryManager vmm, FunctionDirectory dir) {
        this.vmm = vmm;
        this.dir = dir;
        this.memory = new HashMap<>();
    }

    public void loadConstants() {
        for (Map.Entry<String, Integer> e : vmm.getConstTable().entrySet()) {
            String[] parts = e.getKey().split(":"); // "int:5" o "float:2.3"
            Object val = parts[0].equals("int")
                    ? Integer.parseInt(parts[1])
                    : Float.parseFloat(parts[1]);
            memory.put(e.getValue(), val);
        }
    }

    private Object getValue(int addr) {
        if (isGlobal(addr) || isConst(addr))
            return memory.get(addr);
        if (isLocal(addr))
            return localMemory.get(addr);
        if (isTemp(addr))
            return tempMemory.get(addr);
        throw new RuntimeException("Dirección inválida: " + addr);
    }

    private void setValue(int addr, Object val) {
        if (isGlobal(addr))
            memory.put(addr, val);
        else if (isLocal(addr))
            localMemory.put(addr, val);
        else if (isTemp(addr))
            tempMemory.put(addr, val);
        else
            throw new RuntimeException("Dirección inválida: " + addr);
    }

    public void run(List<Cuadruplo> quads) {
        // Registrar etiquetas
        for (int i = 0; i < quads.size(); i++) {
            Cuadruplo q = quads.get(i);
            if ("LABEL".equals(q.getOp())) {
                labelMap.put(q.getRes(), i);
            }
        }

        int pc = 0;
        while (pc < quads.size()) {
            Cuadruplo q = quads.get(pc);
            String op = q.getOp();
            String a1 = q.getArg1();
            String a2 = q.getArg2();
            String res = q.getRes();

            switch (op) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "<":
                case ">":
                case "!=": {
                    int addr1 = Integer.parseInt(a1);
                    int addr2 = Integer.parseInt(a2);
                    Number v1 = (Number) getValue(addr1);
                    Number v2 = (Number) getValue(addr2);
                    Number out = compute(op, v1, v2);
                    setValue(Integer.parseInt(res), out);
                    pc++;
                    break;
                }
                case "=": {
                    int srcAddr = Integer.parseInt(a1);
                    int dstAddr = Integer.parseInt(res);
                    Number val = (Number) getValue(srcAddr);
                    if (val == null)
                        val = 0;
                    setValue(dstAddr, val);
                    pc++;
                    break;
                }
                case "PRINT": {
                    int addr = Integer.parseInt(a1);
                    Number val = (Number) getValue(addr);
                    if (val == null)
                        val = 0;
                    if (isFloatAddress(addr)) {
                        System.out.println(val.floatValue());
                    } else {
                        System.out.println(val.intValue());
                    }
                    pc++;
                    break;
                }
                case "PRINT_STR": {
                    String text = a1;
                    if (text.startsWith("\"") && text.endsWith("\"") && text.length() >= 2) {
                        text = text.substring(1, text.length() - 1);
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
                    int condAddr = Integer.parseInt(a1);
                    Number cond = (Number) getValue(condAddr);
                    if (cond == null)
                        cond = 0;
                    pc = (cond.intValue() == 0) ? labelMap.get(res) : pc + 1;
                    break;
                }
                case "ERA": {
                    pc++;
                    break;
                }
                case "PARAM": {
                    int srcAddr = Integer.parseInt(a1);
                    Object val = getValue(srcAddr);
                    if (val == null)
                        val = 0;
                    pendingParams.add(val);
                    pc++;
                    break;
                }
                case "GOSUB": {
                    returnStack.push(pc + 1);
                    localStack.push(new HashMap<>(localMemory));
                    tempStack.push(new HashMap<>(tempMemory));
                    localMemory = new HashMap<>();
                    tempMemory = new HashMap<>();

                    FunctionInfo fInfo = dir.getFunction(a1);
                    if (fInfo == null)
                        throw new RuntimeException("Función no declarada: " + a1);

                    for (int i = 0; i < pendingParams.size(); i++) {
                        String paramName = fInfo.paramNames.get(i);
                        VariableInfo vi = fInfo.getVariable(paramName);
                        localMemory.put(vi.address, pendingParams.get(i));
                    }
                    pendingParams.clear();

                    pc = labelMap.get(a1);
                    break;
                }
                case "ENDPROC": {
                    if (returnStack.isEmpty())
                        throw new RuntimeException("Error: returnStack vacío en ENDPROC");
                    pc = returnStack.pop();
                    localMemory = localStack.pop();
                    tempMemory = tempStack.pop();
                    break;
                }
                case "LABEL":
                    pc++;
                    break;
                default:
                    pc++;
            }
        }
    }

    private Number compute(String op, Number n1, Number n2) {
        if (n1 == null)
            n1 = 0;
        if (n2 == null)
            n2 = 0;

        switch (op) {
            case "+":
                return (n1 instanceof Float || n2 instanceof Float)
                        ? n1.floatValue() + n2.floatValue()
                        : n1.intValue() + n2.intValue();
            case "-":
                return (n1 instanceof Float || n2 instanceof Float)
                        ? n1.floatValue() - n2.floatValue()
                        : n1.intValue() - n2.intValue();
            case "*":
                return (n1 instanceof Float || n2 instanceof Float)
                        ? n1.floatValue() * n2.floatValue()
                        : n1.intValue() * n2.intValue();
            case "/":
                return (n1 instanceof Float || n2 instanceof Float)
                        ? n1.floatValue() / n2.floatValue()
                        : n1.intValue() / n2.intValue();
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

    // GLOBALS
    private boolean isGlobalInt(int addr) {
        return addr >= 1000 && addr < 2000;
    }

    private boolean isGlobalFloat(int addr) {
        return addr >= 2000 && addr < 3000;
    }

    private boolean isGlobal(int addr) {
        return isGlobalInt(addr) || isGlobalFloat(addr);
    }

    // LOCALS
    private boolean isLocalInt(int addr) {
        return addr >= 3000 && addr < 4000;
    }

    private boolean isLocalFloat(int addr) {
        return addr >= 4000 && addr < 5000;
    }

    private boolean isLocal(int addr) {
        return isLocalInt(addr) || isLocalFloat(addr);
    }

    // TEMPS
    private boolean isTempInt(int addr) {
        return addr >= 5000 && addr < 6000;
    }

    private boolean isTempFloat(int addr) {
        return addr >= 6000 && addr < 7000;
    }

    private boolean isTemp(int addr) {
        return isTempInt(addr) || isTempFloat(addr);
    }

    // CONSTS
    private boolean isConstInt(int addr) {
        return addr >= 7000 && addr < 8000;
    }

    private boolean isConstFloat(int addr) {
        return addr >= 8000 && addr < 9000;
    }

    private boolean isConst(int addr) {
        return isConstInt(addr) || isConstFloat(addr);
    }

    // Helper para impresión
    private boolean isFloatAddress(int addr) {
        return isGlobalFloat(addr) || isLocalFloat(addr) || isTempFloat(addr) || isConstFloat(addr);
    }

}