
package Week6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No_of_Exceptions_in_File {
   
    public static int countExceptions(String filePath) throws FileNotFoundException, IOException 
    {
        int exceptionCount = 0;
        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br =new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) 
            {
                StringTokenizer st = new StringTokenizer(line," ");
                while (st.hasMoreTokens()){
                    String token = st.nextToken();
                    if (token.equals("try") || token.equals("throw"))
                        exceptionCount++;
                }
            }
        }
        catch (FileNotFoundException e) {
            throw e;
        } 
        catch (IOException e) {
            throw e;
        }
        return exceptionCount;
    }
        
    public static void main(String[] args) {
        try {
            int exceptionsCount = countExceptions("W6Q2ReadFile.java");
            System.out.println("Total number of exceptions in file: " + exceptionsCount);
        } 
        catch(FileNotFoundException fNFE){
            System.out.println("FileNotFound Exception has occured.");
        }
        catch(IOException iOE){
            System.out.println("IO Exception has occured.");
        }
    }
}



//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class No_of_Exceptions_in_File {
//    public static void main(String[] args) {
//        String filePath = "Week6Q2.java";
//        int totalExceptions = countExceptions(filePath);
//        System.out.println("Total exceptions found: " + totalExceptions);
//    }
//
//    public static int countExceptions(String filePath) {
//        int exceptionCount = 0;
//        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (line.contains("throw") || line.contains("throws") || line.contains("try")) {
//                    exceptionCount++;
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//        }
//        return exceptionCount;
//    }
//}