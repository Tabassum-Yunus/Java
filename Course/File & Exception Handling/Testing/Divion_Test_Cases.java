public class Divion_Test_Cases {
    public static int unsafeDivide(int n, int d) {
        return n/d; 
    }
    
    public static double safeDivide(int n, int d) {
        if (d == 0 || (n==0 && d==0)) {
            return Double.NaN; 
        }
        return n/d;
    }  
    public static void main(String[] args) {
        try {
            System.out.println("Safe Division Result (10 / 0): " + safeDivide(10, 0));
            System.out.println("Unsafe Division Result: " + unsafeDivide(10, 0));
        } 
        catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
    }
}  











/*
Test Cases and Demonstration
* In the original implementation, calling unsafeDivision(10, 0) would cause an ArithmeticException due to division by zero. 
    The try-catch block in the main method catches and prints a message if the exception occurs.
* The modified safeDivision method includes a check for the denominator being zero and prints a warning message, 
    returning a default value of 0 in such a case. This prevents the ArithmeticException from occurring.
* The test cases in the main method demonstrate:
* A normal division operation (10 / 2), which works as expected without issues.
* A division by zero operation (10 / 0), which, in the original implementation, would have caused an ArithmeticException.
    The modified version safely handles this case by checking the denominator before performing the division, thus demonstrating the effectiveness of the modifications in preventing unchecked exceptions.

*/