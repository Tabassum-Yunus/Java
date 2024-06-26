import java.util.Scanner;                                                                               
public class Floyd_Triangle_0_1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows=input.nextInt();
        for(int i=1; i<=rows; i++){
            for(int j=1,k=1; j<=i; j++){
                if(i%2==0)
                {
                    if(k%2==0)
                        System.out.print("1 ");
                    else
                        System.out.print("0 ");
                    k++;
                }
                else
                {
                    if(k%2==0)
                        System.out.print("0 ");
                    else
                        System.out.print("1 ");
                    k++;
                }
            }
            System.out.println();
        }
    }
}