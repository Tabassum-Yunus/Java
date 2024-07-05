import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Designing_Precompiler1 {

    public static void main(String[] args) {
        try{
            Path sourcePath = Paths.get("Precompiler1_SourceFile.java");       // Source file 
            Path targetPath = Paths.get("Precompiler1_TargetFile.java");       // Target Java file

            byte[] byteRead = Files.readAllBytes(sourcePath);
            String content = new String(byteRead);

            // Transformations
            content = transformSingleLineComments(content);
            content = transformMultiLineComments(content);
            content = transformStatementTerminator(content);
            content = transformBlocks(content);
            
            byte[] byteWrite = content.getBytes();
            Files.write(targetPath, byteWrite);               // Transformed Java file
            
            System.out.println("Pre-compilation successful. Output written to " + targetPath);
        } 
        catch (IOException e) {
            System.err.println("Error reading/writing files: " + e.getMessage());
        }   
    }

    private static String transformSingleLineComments(String content) {     // Method to replace single line comment 
        return content.replace("$ ", "// ");   
    }

    private static String transformMultiLineComments(String content) {      // Method to replace multi line comment 
        content = content.replace("$*", "/*");   
        content = content.replace("*$", "*/");
        return content;
    }
        
    private static String transformStatementTerminator(String content) {    /* Method to replace statement terminator */
        return content.replace("#", ";");
    }

    private static String transformBlocks(String content) {                 /* Method to replace block */
        content = content.replace("[", "{");
        content = content.replace("]", "}");
        return content;
    }

}





