import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] testFiles = args.length > 0 ? args : new String[]{"test01.bd"};

        for (String filePath : testFiles) {
            System.out.println("=== Ejecutando " + filePath + " ===");

            // 1) Parse
            CharStream input = CharStreams.fromFileName(filePath);
            BabyDuckLexer lexer = new BabyDuckLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BabyDuckParser parser = new BabyDuckParser(tokens);
            ParseTree tree = parser.programa();

            // 2) Print parse tree
            System.out.println(tree.toStringTree(parser));

            // 3) Semantic analysis + quadruple generation
            SemanticVisitor visitor = new SemanticVisitor();
            visitor.visit(tree);

            // 4) Print function directory
            System.out.println("\n--- Directorio de Funciones y Variables ---");
            visitor.getFunctionDirectory().getFunctionNames().forEach(fname -> {
                FunctionInfo fi = visitor.getFunctionDirectory().getFunction(fname);
                System.out.println("Función: " + fname + " (retorno=" + fi.returnType + ")");
                fi.getVariableNames().forEach(var -> {
                    VariableInfo vi = fi.getVariable(var);
                    System.out.printf("  %s : tipo=%s, addr=%d, scope=%s%n", var, vi.type, vi.address, vi.scope);
                });
            });

            // 5) Print quadruples (incluye ERA/GOSUB/BEGIN/ENDPROC)
            visitor.getQuadGenerator().printQuadruples();
            System.out.println();
        }
    }
}
