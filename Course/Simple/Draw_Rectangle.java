import java.util.Scanner;
import java.awt.Rectangle;
public class Draw_Rectangle{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x,y coordinate of first rectangle: ");
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        System.out.print("Enter height, width of first rectangle: ");
        int h1 = input.nextInt();
        int w1 = input.nextInt();
        System.out.print("Enter x,y coordinate of second rectangle: ");
        int x2 = input.nextInt();
        int y2 = input.nextInt();
        System.out.print("Enter height, width of second rectangle: ");
        int h2 = input.nextInt();
        int w2 = input.nextInt();
        Rectangle r1=new Rectangle(x1,y1,w1,h1);
        System.out.println("First rectangle is: "+r1);
        Rectangle r2=new Rectangle(x2,y2,w2,h2);
        System.out.println("Second rectangle is: "+r2);
        Rectangle r3 = r1.intersection(r2);
        System.out.println("Intersecting rectangle is: "+r3);
    }
} 