
package Week5;

import java.util.Scanner;
import java.lang.Math;
class Circle{
    private double r;
    private double x;
    private double y;
    public double area(double r)
    {
        return (3.1415*r*r);
    }
    public double circumf(double r)
    {
        return (2*3.1415*r);
    }
    public void loc(int a, int b){
        double d = Math.sqrt(Math.pow(a-x,2)+Math.pow(b-y, 2));   
        if(d>r)
            System.out.println("(" + a + "," + b + ") lies inside the circle.");
        else if(d<r)
            System.out.println("(" + a + "," + b + ") lies outside the circle.");
        else
            System.out.println("(" + a + "," + b + ") lies on the periphery.");
    }
}

public class W5Q2 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int i=0;
        Circle c = new Circle();
        while(true)
        {
            
            System.out.print("\nEnter radius, x & y coordinate of center of circle: ");
            int a = input.nextInt();
            int b = input.nextInt();
            System.out.print("Enter radius of circle: ");
            double r = input.nextDouble();
            if(r<0)
            {
                System.out.println("Sorry! Invalid input.");
                break;
            }
            else
            {
                System.out.println("Area of circle: "+ c.area(r));
                System.out.println("Circumference of circle: "+ c.circumf(r));
                c.loc(a, b);
            }
        }
    }
}

