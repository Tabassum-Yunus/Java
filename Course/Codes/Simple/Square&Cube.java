public class Square&Cube {
    public static void main(String args[]){
        System.out.println("Number      Square      Cube");
        for(int i=1; i<=5; i++)
        {
            System.out.println("  "+i+"          "+Math.pow(i,2)+"        "+Math.pow(i,3));
        }
    }
}