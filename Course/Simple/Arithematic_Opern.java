import java.util.Scanner;
import java.lang.Math;
public class Arithematic_Opern {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = input.nextDouble();
        System.out.print("Enter second number: ");
        double b = input.nextDouble();
        System.out.println("Sum of "+a+" and "+b+" : "+(a+b));
        System.out.println("Difference of "+a+" and "+b+" : "+(a-b));
        System.out.println("Product of "+a+" and "+b+" : "+(a*b));
        System.out.println("Quotient of "+a+" and "+b+" : "+(a/b));
        System.out.println("Maximum of "+a+" and "+b+" : "+ (Math.max(a, b)));
        System.out.println("Minimum of "+a+" and "+b+" : "+ (Math.min(a, b)));
    }
}