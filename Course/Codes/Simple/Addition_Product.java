import java.util.Scanner;
public class Addition_Product {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter four numbers: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        System.out.println("Sum of "+a+", "+b+", "+c+", "+d+" is: "+ (a+b+c+d));
        System.out.println("Product of "+a+", "+b+", "+c+", "+d+" is: "+ (a*b*c*d));
    }
}
//import java.util.Scanner;
//public class W4Q3 {
//    public static void main(String args[]){
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter a number: ");
//        int n = input.nextInt();
//        int r, sum=0, prod=1, d=0;
//        while(n!=0)
//        {
//            r = n%10;
//            sum += r;
//            prod *= r;
//            n/=10;
//        }
//        System.out.println("Sum of digits: "+ sum);
//        System.out.println("Product of digits: "+ prod);
//    }
//}
