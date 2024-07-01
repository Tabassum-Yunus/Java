import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Log_Errors_exit(1) {
    private static final Logger logger = LogManager.getLogger(W7Q3.class);
    public static void main(String[] args) {       
        PropertyConfigurator.configure("D:\\MyNetbeanProgs\\MCA\\JAVAlab\\src\\main\\java\\Week7\\log4j.properties");
        try {
            int[] numbers = {1, 2, 3};
            int index = 5;  
            int value = numbers[index];
            System.out.println("Value at index " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.fatal("An ArrayIndexOutOfBoundsException occurred: " + e.getMessage());
            System.exit(1);
        }        
    }
}