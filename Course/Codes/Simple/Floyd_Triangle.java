import java.util.Scanner;                                                                               
public class Floyd_Triangle{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows=input.nextInt(),k=1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=i; j++)
                System.out.print((k++)+" ");
            System.out.println();
        }
    }
}