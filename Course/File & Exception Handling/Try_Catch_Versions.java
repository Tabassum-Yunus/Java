public class Try_Catch_Versions {
    public static void tryCatchVersion(){
        String str = null;
        try{
            System.out.println("Length of string: "+str.length());
        }
        catch(NullPointerException NPE){
            System.out.println("Null pointer exception has occured");
        }
    }
    public static void defaultExceptionHandlerVersion() {
        String str = null;
            System.out.println("Length of string: "+str.length());
    }
    public static void preventNullPointerExceptionVersion() {
        String str = null; 
        if (str != null) 
            System.out.println("Length of string: "+str.length());
        else 
            System.out.println("String is null, preventing NullPointerException.");
    }
    public static void main(String[] args) {
        //tryCatchVersion();
        //defaultExceptionHandlerVersion();
        preventNullPointerExceptionVersion();
    }
}