import java.util.Scanner;
import java.lang.Math;
public class Round_Ceil_Floor_ofNo {
    public static void main(String args[]){
        double num, numRound, numCeil, numFloor, numInteger;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        num = input.nextDouble();
        numRound = Math.round(num);
        System.out.println("Round value of "+ num + " : "+ numRound);
        numCeil = Math.ceil(num);
        System.out.println("Ceil value of "+ num + " : "+ numCeil);
        numFloor = Math.floor(num);
        System.out.println("Floor value of "+ num + " : "+ numFloor);
        numInteger = (int)num;
        System.out.println(num+" after typecasting into integer: " + numInteger);
    }
}