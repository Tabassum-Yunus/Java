import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parsing {

    public static void main(String[] args) {
        //List<String> list = List.of("123", "t46", "abc", "789", "-101", "1a2b");
        List<String> list = Arrays.asList("123", "t46", "abc", "789", "-101", "1a2b");
        List<Integer> validIntegers = new ArrayList<>();
        for (String str : list) {
            try {
                int convertedInt = Integer.parseInt(str);
                validIntegers.add(convertedInt);
                System.out.println("Successfully converted: " + str);
            } 
            catch (NumberFormatException e) {
                System.out.println("Error converting \"" + str + "\": Invalid integer representation.");
            }
        }
        System.out.println("\nSuccessfully converted integers: " + validIntegers);
        System.out.println("Total successfully converted integers: " + validIntegers.size());
    }
}