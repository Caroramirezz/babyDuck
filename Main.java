import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Lista de archivos de prueba
        String[] testFiles = { "test01.bd", "test03.bd" };

        for (String filePath : testFiles) {
            System.out.println("=== Ejecutando " + filePath + " ===\n");

            // Leer y parsear
            CharStream input    = CharStreams.fromFileName(filePath);
            BabyDuckLexer lexer  = new BabyDuckLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BabyDuckParser parser   = new BabyDuckParser(tokens);
            ParseTree tree          = parser.programa();

            // Visitor semántico + generación de cuádruplos
            SemanticVisitor visitor = new SemanticVisitor();
            visitor.visit(tree);

            // 1) Imprimir árbol de derivación
            System.out.println(tree.toStringTree(parser));

            // 2) Imprimir directorio de funciones y variables
            System.out.println("\n--- Directorio de funciones y variables ---");
            FunctionDirectory dir = visitor.getFunctionDirectory();
            for (String fname : dir.getFunctionNames()) {
                FunctionInfo finfo = dir.getFunction(fname);
                System.out.println("Función: " + fname + " (retorno=" + finfo.returnType + ")");
                System.out.println("  Variables:");
                for (String vname : finfo.getVariableNames()) {
                    VariableInfo vinfo = finfo.getVariable(vname);
                    System.out.println("    " + vname + " : tipo=" + vinfo.type + " (scope=" + vinfo.scope + ")");
                }
            }

            // 3) Imprimir cuádruplos generados
            System.out.println("\n--- Cuádruplos Generados ---");
            visitor.getQuadGenerator().printQuadruples();

            System.out.println("\n");  // separación antes del siguiente test
        }
    }
}
