package Assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Aq4_Occ_char_word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        HashMap<Character, Integer> ch = new HashMap<>();
        Map<String, Integer> word = new HashMap<>();
        char[] arr = str.toCharArray();
        for(char c: arr){
            if(!ch.containsKey(c))
                ch.put(c, 1);
            else
                ch.put(c, ch.get(c)+1);
        }
        System.out.println("Frequency of each ccharacter: "+ch);
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens())
        {
            String token = st.nextToken();
            if(!word.containsKey(token))
                word.put(token, 1);
            else
                word.put(token, word.get(token)+1);
        }
        System.out.println("Frequency of each Word: "+word);
    }
}
