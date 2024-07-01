public class Sum_of_reciprocals {
public static void main(String[] args){
    double sum=0;
    for(double i=1;i<=10;i++) 
        sum=sum+1/i; 
    System.out.println("Sum of the reciprocals 1/1+1/2+1/3+1/4+---------+1/10 is: "+sum);
    } 
}