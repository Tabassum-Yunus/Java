import java.util.Scanner;
class OddAndEven{
    private int countOfOdd; 
    private int countOfEven;
    public void addNumber(int n){
        if(n%2==0)
            countOfEven++;
        else
            countOfOdd++;
    }
    public String toString(){                // in-built methhod in java that returns the value given to it in string format
        return ("Number of Odd: "+ countOfOdd + "\nNumber of Even: "+ countOfEven); 
}
}
class TestOddAndEven{
    OddAndEven oAE = new OddAndEven();
    public void test(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("Enter any number or Q/q to stop: ");
            String ch = input.nextLine();
            if(ch.equals("Q")|| ch.equals("q"))            
                break;
            else{
                int i = Integer.parseInt(ch);
                oAE.addNumber(i);
            }
        }
        //oAE.toString();
        //System.out.println(oAE);
        System.out.println(oAE.toString());
    }
}
public class Count_Even_Odd {
    public static void main(String args[]){
        TestOddAndEven t = new TestOddAndEven();
        t.test();
    }
}

