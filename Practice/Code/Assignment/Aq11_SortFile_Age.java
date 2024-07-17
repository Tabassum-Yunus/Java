
package Assignment;
                                                                        // Q11
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


class Pet{
    String name;
    int age;
    Pet(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return name + " " +age;
    }
}

class cmp implements Comparator<Pet>{
    @Override
    public int compare(Pet p1, Pet p2){
        return (p1.age-p2.age);
    }
//    public int compare(Pet p1, Pet p2){
//        return (p1.name.compareTo(p2.name));
//    }
}

public class Aq11_SortFile_Age {
    public static void main(String[] args) {
        List<Pet> pet_list = new ArrayList<>();
        try{
            FileReader fr = new FileReader("SortFile_Age.txt");
            BufferedReader br = new BufferedReader(fr);
            String line; String name = null;
            int age = 0;
            StringTokenizer st ;
            while((line = br.readLine()) != null)
            {
                st = new StringTokenizer(line);
                 while(st.hasMoreTokens()){
                     String token = st.nextToken(", ");
                     //System.out.println("Token: "+token);
                     try{
                         age = Integer.parseInt(token);
                         System.out.println("Age: "+age);
                     }
                     catch(NumberFormatException n){
                         name = token;
                         System.out.println("Name: "+ name);
                     }
//                     Pet p = new Pet(name, age);
//                     System.out.println(p.name);
//                     System.out.println(p.age);
//                     pet_list.add(p);
                 }   
                 Pet p = new Pet(name, age);
                 System.out.println(p.name);
                 System.out.println(p.age);
                 pet_list.add(p);
            }
            System.out.println(pet_list);
            Collections.sort(pet_list, new cmp());
            System.out.println(pet_list);
            br.close();
            fr.close();
            
            FileWriter fw = new FileWriter("SortFile_Age.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(Pet p:pet_list )
            {
                bw.write(p.name+", ");
                bw.write(p.age+"\n");
            }
            bw.close();
            fw.close();
        }
        catch(IOException e){}
    }
}
