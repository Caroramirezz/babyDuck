import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] testFiles = args.length > 0 ? args : new String[]{"testExpr.bd"};

        for (String filePath : testFiles) {
            System.out.println("=== Ejecutando " + filePath + " ===\n");

            // 1) Parseo
            CharStream input    = CharStreams.fromFileName(filePath);
            BabyDuckLexer lexer  = new BabyDuckLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BabyDuckParser parser   = new BabyDuckParser(tokens);
            BabyDuckParser.ProgramaContext tree = parser.programa();

            System.out.println("Árbol sintáctico:");
            System.out.println(tree.toStringTree(parser));
            System.out.println();

            // 2) Semántica + cuádruplos
            SemanticVisitor visitor = new SemanticVisitor();
            visitor.visitPrograma(tree);

            // 3) Directorio de funciones y variables
            System.out.println("--- Directorio de Funciones y Variables ---");
            for (String fname : visitor.getFunctionDirectory().getFunctionNames()) {
                FunctionInfo fi = visitor.getFunctionDirectory().getFunction(fname);
                System.out.println("Función: " + fname + " (retorno=" + fi.returnType + ")");
                for (String var : fi.getVariableNames()) {
                    VariableInfo vi = fi.getVariable(var);
                    System.out.printf("  %s : tipo=%s, addr=%d, scope=%s%n",
                                      var, vi.type, vi.address, vi.scope);
                }
            }

            // 4) Imprimir cuádruplos
            visitor.getQuadGenerator().printQuadruples();

            // 5) Ejecutar Máquina Virtual
            VirtualMachine vm = new VirtualMachine(visitor.getVirtualMemoryManager());
            vm.loadConstants();
            System.out.println("\n--- Salida de la Máquina Virtual ---");
            List<Cuadruplo> quads = visitor.getQuadGenerator().getQuadruples();
            vm.run(quads);

            System.out.println("\n");
        }
    }
}
