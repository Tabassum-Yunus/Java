import java.util.Scanner;
public class Even_Odd {
    public static void main(String args[]){
        int n, even=0,odd=0;
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.print("Enter next number or -1 to stop: ");
            n = input.nextInt();
            if(n == -1)
                break;
            if(n%2==0)
                even++;
            else
                odd++;
        }
        System.out.println("  Number of Even: "+ even);
        System.out.println("  Number of Odd: "+ odd);
    }
}


//import java.util.Scanner;
//public class W3Q1 {
//    public static void main(String args[]){
//        int odd=0, even=0;
//        Scanner input=new Scanner(System.in);
//        for(int i=1;i>0;i++){
//        System.out.println("Enter any number or q to stop: ");
//        String str=input.nextLine();
//        if(str.equals("q")&&!str.equals("Q"))
//        {
//        } 
//        else 
//        {
//            break;
//        }
//        int a=Integer.parseInt(str);
//        if(a%2==0)
//            even++;
//        else
//            odd++;
//        }
//    }
//}