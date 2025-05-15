public class Cuadruplo {
    public final String op, arg1, arg2, res;

    public Cuadruplo(String op, String arg1, String arg2, String res) {
        this.op   = op;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.res  = res;
    }

    @Override
    public String toString() {
        return "(" + op + ", " + arg1 + ", " + arg2 + ", " + res + ")";
    }
}
