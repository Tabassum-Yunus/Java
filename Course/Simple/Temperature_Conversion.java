import java.util.*;
public class Temperature_Conversion{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in fahrenheit: ");
        double f = input.nextDouble();
        double c = (f-32)*(5.0/9);
        System.out.println("Temperature in fahrenheit   " + "  Temperature in Celsius");
        System.out.println("         " + f + "                    " + c);
    }
}