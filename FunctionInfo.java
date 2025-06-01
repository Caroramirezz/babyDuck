import java.util.*;

public class FunctionInfo {
    public String returnType;
    public List<String> paramNames = new ArrayList<>();
    public List<String> paramTypes;
    public Map<String, VariableInfo> varTable;

    public FunctionInfo(String returnType) {
        this.returnType = returnType;
        this.paramTypes = new ArrayList<>();
        this.varTable = new HashMap<>();
    }

    public void addParam(String name, String type, int address) {
        paramTypes.add(type);
        paramNames.add(name);
        varTable.put(name, new VariableInfo(type, address, "local"));
    }

    public void addParamType(String type) {
        this.paramTypes.add(type);
    }

    public boolean addVariable(String name, VariableInfo info) {
        if (varTable.containsKey(name))
            return false;
        varTable.put(name, info);
        return true;
    }

    public VariableInfo getVariable(String name) {
        return varTable.get(name);
    }

    public Set<String> getVariableNames() {
        return Collections.unmodifiableSet(varTable.keySet());
    }
}
