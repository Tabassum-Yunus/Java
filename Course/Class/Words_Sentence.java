import java.util.Scanner;
import java.util.StringTokenizer;
public class Words_Sentence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
        int eC = 0, zC = 0, sentenCount = 1 ;
        System.out.print("Enter Text: " );
        String text = sc.nextLine( ) ;
        StringTokenizer st = new StringTokenizer(text); 
        System.out.println("Number of words in the text is : " + st.countTokens() );
        while (st.hasMoreTokens()){
            String TokenCheck= st.nextToken() ;
            for (int i = 0 ;i< TokenCheck.length() ; i++) {
                if (TokenCheck.charAt(i) == 'e')
                    eC++;
                else if (TokenCheck.charAt(i) == 'z')
                    zC++; 
                else if (TokenCheck.charAt(i) == '.')
                   sentenCount++;
            } 
        }
        System.out.println("Number of sentences in the text : " +sentenCount );
        System.out.println("Number of times the letter 'e' occurs in the text : " +eC );
        System.out.println("Number of times the letter 'z' occurs in the text : " +zC ); 
    } 
}