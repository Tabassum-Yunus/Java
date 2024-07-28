
package Practice.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
    String name;
    int age;
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return name+" "+age;
    }
}
public class C_Merge_Diff_Lists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();
        List<Student> student = new ArrayList<>();
        while(true)
        {
            System.out.print("Enter name and age or Q for exit: ");
            String name = sc.next();
            if(name.equalsIgnoreCase("q"))
                break;
            int age = sc.nextInt();
            names.add(name);
            ages.add(age);
        }
        System.out.println(names);
        System.out.println(ages);
        
        for(int i=0; i<names.size(); i++){
            Student st = new Student(names.get(i), ages.get(i));
            student.add(st);
        }
        System.out.println(student);
        
//        List<Object> obj = new ArrayList<>();
//        obj.addAll(names);
//        obj.addAll(ages);
//        System.out.println(obj);
    }
}
