import java.util.*;

public class VirtualMemoryManager {
    private int nextGlobalInt   = 1000;
    private int nextGlobalFloat = 2000;
    private int nextLocalInt    = 3000;
    private int nextLocalFloat  = 4000;
    private int nextTempInt     = 5000;
    private int nextTempFloat   = 6000;
    private int nextConstInt    = 7000;
    private int nextConstFloat  = 8000;

    private Map<String,Integer> constTable = new HashMap<>();

    public int allocGlobal(String type) {
        return type.equals("float") ? nextGlobalFloat++ : nextGlobalInt++;
    }

    public int allocLocal(String type) {
        return type.equals("float") ? nextLocalFloat++ : nextLocalInt++;
    }

    public int allocTemp(String type) {
        return type.equals("float") ? nextTempFloat++ : nextTempInt++;
    }

    public int allocConst(String value, String type) {
        String key = type + ":" + value;
        if (!constTable.containsKey(key)) {
            int addr = type.equals("float") ? nextConstFloat++ : nextConstInt++;
            constTable.put(key, addr);
        }
        return constTable.get(key);
    }
}
