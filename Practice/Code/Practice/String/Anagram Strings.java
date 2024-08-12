package Practice.String;

import java.util.Arrays;

public class A_Anagram_Aq7 {
    public static void main(String[] args) {
        String str1 = "Parliamnt", str2 = "Partial men";
        str1 = str1.replace(" ", "");
        str2 = str2.replace(" ", "");
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        str1 = new String(arr1);
        str2 = new String(arr2);
        if(str1.equals(str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
