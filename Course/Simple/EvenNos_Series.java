import java.util.Scanner; 
public class EvenNos_Series{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of even numbers: ");
        int sum=0,N=input.nextInt();
        for(int i=1,j=2;i<=N;i++){
            sum+=j;
            j+=2;
        }
        System.out.println("Sum of 2+4+6+------+"+N+" : "+sum);
    }
}
