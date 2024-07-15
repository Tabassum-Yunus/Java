
package Assignment;

public class Aq6_Pangram {
    public static void main(String[] args) {
        String str = "Pack my box with five dozen liquor jugs";
        StringBuffer sb = new StringBuffer();
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            String substr = str.substring(i,i+1);
            if(sb.indexOf(substr)==-1)
            {
                if(str.charAt(i)>=97 && str.charAt(i)<=122)
                {
                    sb.append(substr);
                }
                    
            }
                
        }
        if(sb.length()==26)
            System.out.println("Pangram");
    }
}
