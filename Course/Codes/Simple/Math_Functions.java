import java.util.Scanner;
import java.lang.Math;
public class Math_Functions{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two number: ");
        double num = input.nextDouble();
        double no = input.nextDouble();
        System.out.println(" Sign of "+ num + " : "+ (Math.signum(num)));
        System.out.println(" Absolute value of "+ num + " : "+ (Math.abs(num)));
        System.out.println(" Square root of "+ num + " : "+ (Math.sqrt(num)));
        System.out.println(" Cube root of "+ num + " : "+ (Math.cbrt(num)));
        System.out.println(" Log10 value of "+ num + " : "+ (Math.log10(num)));
        System.out.println(" Value after "+ num + " : "+ (Math.nextUp(num)));
        System.out.println(" Value before "+ num + " : "+ (Math.nextDown(num)));
        System.out.println(" Sine value of "+ num + " : "+ (Math.sin(num)));
        System.out.println(" Cosine value before "+ num + " : "+ (Math.cos(num)));
        System.out.println(" Sqrt((" + num + ")^2+(" + no + ")^2) : "+ (Math.hypot(num, no)));
    }
}