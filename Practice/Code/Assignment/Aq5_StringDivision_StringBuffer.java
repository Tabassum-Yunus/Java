package Assignment;

import Practice.String.*;
import java.util.StringTokenizer;

public class Aq5_StringDivision_StringBuffer {
    public static void main(String[] args) {
        String s= "Aligarh Muslim University was established in 1875";
        StringTokenizer st = new StringTokenizer(s);
        StringTokenizer s1 = new StringTokenizer(s);
        int l =0, n=st.countTokens();
        System.out.println(st.countTokens());
        while(st.hasMoreTokens())
        {
            String token = st.nextToken(" ");
            l += token.length();
        }
        int avg = l/n;
        StringBuffer sbl = new StringBuffer();
        StringBuffer sbg = new StringBuffer();
        while(s1.hasMoreTokens())
        {
            String token = s1.nextToken(" ");
            if(token.length()<=avg)
                sbl.append(token+" ");
            else
                sbg.append(token+" ");
        }
        System.out.println("sbl: "+sbl);
        System.out.println("sbg: "+sbg);
    }
}
