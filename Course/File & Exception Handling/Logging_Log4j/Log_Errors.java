import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Log_Errors {
    private static final Logger logger = LogManager.getLogger(W7Q2.class);
    public static void main(String[] args) {      
        PropertyConfigurator.configure("D:\\MyNetbeanProgs\\MCA\\JAVAlab\\src\\main\\java\\Week7\\log4j.properties");
        try {
            int[] numbers = {1, 2, 3};
            int index = 4;  
            int value = numbers[index];
            System.out.println("Value at index " + index + ": " + value);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            logger.error("An ArrayIndexOutOfBoundsException occurred: " + e.getMessage());
        }        
    }
}