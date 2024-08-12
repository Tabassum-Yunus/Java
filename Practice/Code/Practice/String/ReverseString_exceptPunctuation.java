package Practice.String;

import java.util.StringTokenizer;


public class I_ReverseString_exceptPunctuation {
    public static void main(String[] args) {
        String str = "Go ye, Now!";
        
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            reverse(token);
            
        }
    }
    
    public static void reverse(String str){
        String rev="";
        for (int i = str.length()-1; i >=0 ; i--) {
            char c=str.charAt(i);
            if((c>=97 && c<=122) ||(c>=65 && c<=90))
                rev = rev+c;
        }
        
        int k=0;
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if((c>=97 && c<=122) ||(c>=65 && c<=90))
                System.out.print(rev.charAt(k++));
            else
                System.out.print(c);
        }
        System.out.print(" ");
    }
}
