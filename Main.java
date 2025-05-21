import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Si me pasan nombres por args, los uso;  
        // si no, uso estos por defecto:
        String[] testFiles = (args.length > 0)
            ? args
            : new String[]{ "test01.bd", "test03.bd" };

        for (String filePath : testFiles) {
            System.out.println("=== Ejecutando " + filePath + " ===\n");

            CharStream input    = CharStreams.fromFileName(filePath);
            BabyDuckLexer lexer  = new BabyDuckLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BabyDuckParser parser   = new BabyDuckParser(tokens);
            ParseTree tree          = parser.programa();

            SemanticVisitor visitor = new SemanticVisitor();
            visitor.visit(tree);

            // … el resto igual …
            System.out.println(tree.toStringTree(parser));
            System.out.println("\n--- Directorio de funciones y variables ---");
            FunctionDirectory dir = visitor.getFunctionDirectory();
            for (String fname : dir.getFunctionNames()) {
                FunctionInfo finfo = dir.getFunction(fname);
                System.out.println("Función: " + fname + " (retorno=" + finfo.returnType + ")");
                for (String vname : finfo.getVariableNames()) {
                    VariableInfo vinfo = finfo.getVariable(vname);
                    System.out.printf("    %s : tipo=%s (scope=%s)%n", vname, vinfo.type, vinfo.scope);
                }
            }
            System.out.println("\n--- Cuádruplos Generados ---");
            visitor.getQuadGenerator().printQuadruples();
            System.out.println("\n");
        }
    }
}
