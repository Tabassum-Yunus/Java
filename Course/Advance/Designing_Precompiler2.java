import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.*;
import java.util.regex.*;

public class Designing_Precompiler2 {

    public static void main(String[] args)  {
        Path sourcePath = Paths.get("Precompiler2_File.java");
        try{
            String content = new String(Files.readAllBytes(sourcePath));
            System.out.println("Number of integer variables: " + countMatches(content, "int"));
            System.out.println("Number of float variables: " + countMatches(content, "float"));
            System.out.println("Number of String variables: " + countMatches(content, "String"));

            System.out.println("Number of for loops: " + countMatches(content, "for"));
            System.out.println("Number of while loops: " + countMatches(content, "\\bwhile\\s*\\("));
            System.out.println("Number of do-while loops: " + countMatches(content, "\\bdo\\s*\\{"));
//System.out.println("Number of do-while loops: " + countMatches(content, "\\bdo\\s*\\{\\.\\bwhile\\s*\\(\\.\\);"));

            System.out.println("Number of if conditions: " + countMatches(content, "if"));

            System.out.println("Number of user-defined methods: " + countUserDefinedMethods(content));
        }
        catch(IOException e){}


    }

    private static int countMatches(String content, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(content);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static int countUserDefinedMethods(String content) {
        Pattern p = Pattern.compile("\\b(public|protected|private|static)\\s+\\w+\\s+\\w*\\(");
        Matcher matcher = p.matcher(content);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
