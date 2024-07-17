package Assignment;
                                                                    // Q10
import Practice.File.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Aq10_Swap_HalfContent {
    public static void main(String[] args) {
        try{
            FileReader frA = new FileReader("File A.txt");
            BufferedReader brA = new BufferedReader(frA);
            FileReader frB = new FileReader("File B.txt");
            BufferedReader brB = new BufferedReader(frB);
            String sA = new String(), sB ="", line;
            while((line = brA.readLine())!=null)
            {
                sA += line +"\n";
            }
            System.out.println(sA);
            while((line = brB.readLine())!=null)
            {
                sB += line +"\n";
            }
            System.out.println(sB);
            brB.close();
            frB.close();
            brA.close();
            frA.close();
            
            String sA1 = sA.substring(0, sA.length()/2);
            String sA2 = sA.substring(sA.length()/2);
            String sB1 = sB.substring(0, sB.length()/2);
            String sB2 = sB.substring(sA.length()/2);
            
//            char[] sA_arr = sA.toCharArray();
//            char[] sB_arr = sB.toCharArray();
//            
//            String sA1 = new String(sA_arr, 0, (sA_arr.length/2));
//            System.out.println(sA1);
//            String sA2 = new String(sA_arr, sA_arr.length/2, sA_arr.length/2);
//            System.out.println(sA2);
//            
//            String sB1 = new String(sB_arr, 0, (sB_arr.length/2));
//            System.out.println(sB1);
//            String sB2 = new String(sB_arr, sB_arr.length/2, sB_arr.length/2); 
//            System.out.println(sB2);

            FileWriter fwA = new FileWriter("File A.txt");
            BufferedWriter bwA = new BufferedWriter(fwA);
            FileWriter fwB = new FileWriter("File B.txt");
            BufferedWriter bwB = new BufferedWriter(fwB);
            
            bwA.write(sB1+sA2);
            bwB.write(sB2+sA1);
            
            bwB.close();
            fwB.close();
            bwA.close();
            fwA.close();
        }
        catch(IOException e){}
    }
}
