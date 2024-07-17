package Assignment;


import Practice.Collections.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class Employee{
    String name;
    double salary;
    int age;
    Employee(String name, double salary, int age){
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
    public String toString(){
        return ("Name:"+name+" Salary:"+salary+" Age:"+age);
    }
}

class cmp implements Comparator<Employee>{
    public int compare(Employee e1, Employee e2){
        //return (e1.age-e2.age);
        return (e1.name.compareTo(e2.name));
    }
}

public class Aq14_Employee_List {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Employee> emp = new LinkedList<>();
        String lName;
        double lSalary; int lAge;
        Employee e;
        while(true){
            System.out.print("Enter name, salary and age or Q for exit: ");
            //lName = sc.nextLine();
            lName = sc.next();
            if(lName.equalsIgnoreCase("q"))
                break;
            lSalary = sc.nextDouble();
            lAge = sc.nextInt();
            System.out.println("Name: "+lName);
            System.out.println("Salary: "+lSalary);
            System.out.println("Age: "+ lAge);
            e = new Employee(lName, lSalary, lAge);
            emp.add(e);
        }
        System.out.println(emp);
        Collections.sort(emp, new cmp());
        System.out.println(emp);
        
        LinkedList<String> names = new LinkedList<>();
        LinkedList<Double> salaries = new LinkedList<>();
        LinkedList<Integer> ages = new LinkedList<>();
        for(Employee em:emp){
            names.add(em.name);
            salaries.add(em.salary);
            ages.add(em.age);
        }
        System.out.println(names);
        System.out.println(salaries);
        System.out.println(ages);
    }
}
