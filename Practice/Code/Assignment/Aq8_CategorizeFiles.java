package Assignment;

import Practice.File.*;
import java.io.File;
import java.io.IOException;

public class Aq8_CategorizeFiles {
    public static void main(String[] args) {
        File f = new File("MyDirectory");
        f.mkdir();
        try{
            File f1 = new File(f,"file1.txt");
            f1.createNewFile();
            File f2 = new File(f,"file1.xls");
            f2.createNewFile();
            File f3 = new File(f,"file1.docx");
            f3.createNewFile();
            File f4 = new File(f,"file2.txt");
            f4.createNewFile();
            File f5 = new File(f,"file2.xls");
            f5.createNewFile();
            File f6 = new File(f,"file2.docx");
            f6.createNewFile();
            
            File[] allFiles = f.listFiles();
            
            for(File fl:allFiles){

                String str = fl.getName();
                String ext[] = str.split("\\.");
                System.out.println(ext[1]);
                File childDirectory = new File(f,ext[1]);
                childDirectory.mkdir();
                File move = new File(childDirectory+"\\"+fl.getName());
                fl.renameTo(move);
                
                //file_t.renameTo(new File(file_t.getParent()+" "+ext[1]+"\\"+file_t.getName()));
            }
        }
        catch(IOException e){}
    }
}
