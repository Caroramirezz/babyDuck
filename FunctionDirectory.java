import java.util.*;

public class FunctionDirectory {
    private Map<String, FunctionInfo> dir;
    public String currentFunction = "global";

    public FunctionDirectory() {
        dir = new HashMap<>();
        dir.put("global", new FunctionInfo("void")); // contexto global
    }

    public boolean addFunction(String name, String returnType) {
        if (dir.containsKey(name))
            return false;
        dir.put(name, new FunctionInfo(returnType));
        return true;
    }

    public boolean addVariableToCurrent(String name, String type, int address) {
        FunctionInfo func = dir.get(currentFunction);
        if (func == null)
            return false;
        return func.addVariable(name, new VariableInfo(type, address, currentFunction));
    }

    public FunctionInfo getFunction(String name) {
        return dir.get(name);
    }

    public void setCurrentFunction(String name) {
        currentFunction = name;
    }

    public Set<String> getFunctionNames() {
        return Collections.unmodifiableSet(dir.keySet());
    }
}
