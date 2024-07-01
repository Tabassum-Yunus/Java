import java.util.Scanner;
class Commission{
    private int sales;
    Commission(int sales){
        this.sales=sales;
    }
    public double commission(){
        if(sales<500)
            return (0.02*sales);
        else if(sales>=500 && sales<5000)
            return (0.05*sales);
        else
            return (0.08*sales);
    } 
}
class Demo{
    Demo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter sales: ");
        int s = input.nextInt();
        if(s<0)
            System.out.println("Invalid Input");
        else
        {
            Commission com = new Commission(s);
            System.out.println("Commission on Rs "+s+": "+String.format("%.2f",com.commission()));
        }
    }
}
public class Cal_Commission{
    public static void main(String args[]){
        Demo d = new Demo();
    }
}
