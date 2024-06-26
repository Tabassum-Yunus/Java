import java.util.Scanner;
public class Fibbonacci_Series {
    public static void main(String args[]){
        int n, n1=0, n2=1, n3, i=3;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter no of terms you want in series: ");
        n = input.nextInt();
        System.out.print("Fibbonacci Series: "+n1+" "+n2+" ");
        do{
            n3=n1+n2;
            n1=n2;
            n2=n3;
            System.out.print(n3+" ");
            i++;
        }while(i<=n);
    }
}