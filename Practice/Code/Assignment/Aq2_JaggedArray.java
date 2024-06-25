package Assignment;

import Practice.*;
import java.util.Scanner;
public class Aq2_JaggedArray {
    public static void main(String[] args) {
        int k=0, row;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no of rows: ");
        row = input.nextInt();
        int a[][] = new int[row][];
        for(int i=0; i<row; i++)
        {
            a[i] = new int[i+1];
            for (int j = 0; j < i; j++) 
            {
                a[i][j] = (++k);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
