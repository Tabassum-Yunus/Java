package Week8;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

class DateParsingException extends Exception {
    public DateParsingException(String message) {
        super(message);
    }
}

class AutoCloseableDateFormat implements AutoCloseable {
    private final DateFormat dateFormat;
    
    public AutoCloseableDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    Date parse(String source) throws ParseException {
        return dateFormat.parse(source);
    }

    @Override
    public void close() {
        System.out.println("DateFormat resource is being 'closed'.");
    }
}

public class Parse_Date {
    public static void main(String[] args) throws DateParsingException{
        //String incorrectDateString = "March 32 2024";         //LONG
        String incorrectDateString = "Mar 40, 2024";            //MEDIUM
        try (AutoCloseableDateFormat acdf = new AutoCloseableDateFormat(DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US))) {
            System.out.println(acdf.parse(incorrectDateString));
        } 
        catch (ParseException e) {
            throw new DateParsingException("Failed to parse the date.");
        } 
        finally {
            System.out.println("The DateFormat object was properly handled.");
        }
    }
}





//public class public class Parse_Date {
//    public static Date parseDate(String dateString) throws DateParsingException {
//        try  {
//            SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/mm/yyyy");
//            return myDateFormat.parse(dateString);
//        } catch (ParseException e) {
//            throw new DateParsingException("Error parsing date: " + dateString);
//        }
//    }
//    public static void main(String[] args) {
//        String dateString = "24-03-2024"; // Intentionally incorrect date format
//        try {
//            Date date = parseDate(dateString);
//            System.out.println("Parsed date: " + date);
//        } catch (DateParsingException e) {
//            System.err.println("Failed to parse date: " + e.getMessage());
//        }
//    }    
//}