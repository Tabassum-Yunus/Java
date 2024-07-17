package Assignment;

import Practice.File.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Aq12_InstancesOf_UseInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try ( FileReader fr = new FileReader("InstanceOfUserInput.txt")) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            int a, b;
            while (true) {
                int count = 0;
                System.out.print("Enter integer or Q for exit: ");
                String s = sc.next();
                if (s.equalsIgnoreCase("q")) {
                    break;
                } else {
                    a = Integer.parseInt(s);
                    br.mark(0);
                    while ((line = br.readLine()) != null) {
                        b = Integer.parseInt(line);
                        if (a == b) {
                            count++;
                        }
                    }
                    System.out.println("Intances of " + a + " : " + count);
                    //br.reset();
                }
            }
            br.close();
        } catch (IOException e) {
        }
    }
}
