public class VariableInfo {
    
    public String type;      // int, float, string
    public int address;      // optional: memory address
    public String scope;     // global, local, etc.

    public VariableInfo(String type, int address, String scope) {
        this.type = type;
        this.address = address;
        this.scope = scope;
    }
}
