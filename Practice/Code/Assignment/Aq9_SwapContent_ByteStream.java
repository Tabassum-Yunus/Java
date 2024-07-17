package Assignment;
// Q9

import Practice.File.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Aq9_SwapContent_ByteStream {

    public static void main(String[] args) {
        try {
            FileInputStream fin1 = new FileInputStream("File1_Swap.txt");
            FileInputStream fin2 = new FileInputStream("File2_Swap.txt");
            byte[] file1 = fin1.readAllBytes();
//            String s = new String(file1);
//            System.out.println(s);
            byte[] file2 = fin2.readAllBytes();

//            int i=0,j=0;
//            byte[] file1 = new byte[fin1.available()], file2 = new byte[fin2.available()]; 
//            while(fin1.available()!=0){
//                file1[i] = (byte)fin1.read();
//                i++;
//            }
//            while(fin2.available()!=0){
//                file2[j] = (byte)fin2.read();
//                j++;    
//            }
            fin1.close();
            fin2.close();

            FileOutputStream fout1 = new FileOutputStream("File1_Swap.txt");
            FileOutputStream fout2 = new FileOutputStream("File2_Swap.txt");
            fout1.write(file2);
            fout2.write(file1);
            fout1.close();
            fout2.close();
        } catch (IOException e) {
        }
    }
}
