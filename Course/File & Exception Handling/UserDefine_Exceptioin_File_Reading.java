import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileInputException extends Exception {
    public FileInputException(String message) {
        System.out.println(message);
    }
}

public class UserDefine_Exceptioin_File_Reading {  
     public static void readFile(String filename) throws FileInputException {
        try (FileReader r = new FileReader(filename)) {
            int character;
            System.out.print("File Content: ");
            while ((character = r.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println("");
        } 
        catch (FileNotFoundException e) {
            throw new FileInputException("File not found: " + filename);
        } 
        catch (IOException e) {
            throw new FileInputException("An IO error occurred while reading the file.");
        } 
        finally {
            System.out.println("FileReader object closed successfully.");
        }
    }
     
    public static void main(String[] args) {
        String filename = "W9ReadFile.txt";
        try {
            readFile(filename);
        } catch (FileInputException e) {
            System.err.println("Failed to read file: " + e.getMessage());
        }
    }   
}



