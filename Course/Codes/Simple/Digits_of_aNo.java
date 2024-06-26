import java.util.Scanner;
public class Digits_of_aNo {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        int no=n, num=0, r, i=1;
        while(n!=0)
        {
            r = n%10;
            num = num*10 + r;
            n/=10;
        }
        while(num!=0)
        {
            r=num%10;
            System.out.println(i+" digit of "+ no + " : " + r);
            i++;
            num/=10;
        }
    }
}