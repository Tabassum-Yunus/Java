import java.util.Scanner;
public class Addition{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        float x = input.nextFloat();
        System.out.print("Enter second number: ");
        float y = input.nextFloat();
        System.out.println("Addition of "+ x + " and " + y + " : " +(x+y));
    }
}