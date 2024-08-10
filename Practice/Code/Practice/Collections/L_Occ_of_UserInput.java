package Practice.Collections;

import java.util.HashMap;
import java.util.Scanner;

public class L_Occ_of_UserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        int n;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while(true){
            System.out.println("Enter int or q for exit: ");
            s = sc.next();
            try{
                n = Integer.parseInt(s);
                if(!hm.containsKey(n))
                    hm.put(n,1);
                else
                    hm.put(n, hm.get(n)+1);
            }
            catch(NumberFormatException e){
                if(s.equalsIgnoreCase("q"))
                    break;
            }
        }
        System.out.println("Intances of user input: ");
        System.out.println(hm);
    }
}
