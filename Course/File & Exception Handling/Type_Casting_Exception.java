import java.util.ArrayList;
import java.util.List;

public class Type_Casting_Exception {

    public static void main(String[] args) {
       
        List<Object> objects = List.of('t',"Str",46,78.9,-101,"1a2b",'j',76.0);
        List<Object> CastedObjects = new ArrayList<>();

//        for (Object o : objects) 
//                System.out.println(o);

        for (Object obj : objects) {
            try {
                Character castedToChar = (Character) obj;
                CastedObjects.add(castedToChar);
                System.out.println("Successfully casted to Character: " + castedToChar);
            }
            catch (ClassCastException e) {
                try {
                    Integer castedToInt = (Integer) obj;
                    CastedObjects.add(castedToInt);
                    System.out.println("Successfully casted to Integer: " + castedToInt);
                }
                catch (ClassCastException e1) {
                    try {
                        Double castedToDouble = (Double) obj;
                        CastedObjects.add(castedToDouble);
                        System.out.println("Successfully casted to Double: " + castedToDouble);
                    }
                    catch (ClassCastException e2) {
                        try {
                            String castedToString = (String) obj;
                            CastedObjects.add(castedToString);
                            System.out.println("Successfully casted to String: " + castedToString);
                        } 
                        catch (ClassCastException e3) {
                            System.out.println("Error casting object of type " + obj.getClass().getSimpleName() + " to a different type.");
                        }
                    }
                } 
            }
        }

        System.out.println("\nSuccessfully casted objects: " + CastedObjects);
        System.out.println("No. of successfully casted objects: " + CastedObjects.size());
    }
}


