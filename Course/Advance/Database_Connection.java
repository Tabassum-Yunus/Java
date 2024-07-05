package Week8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class MyDBConnectionException extends Exception {
    public MyDBConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Database_Connection {
    private static void connectToDatabase(String dbUrl) throws MyDBConnectionException {
        String username = "system";
        var password = "system";
        try(Connection con = DriverManager.getConnection(dbUrl, username, password)) {
            System.out.println("Database connection established successfully.");
        } catch (SQLException e) {
            throw new MyDBConnectionException("Failed to connect to the database", e);
        } 
        finally {
            System.out.println("Database connection closure attempt was made.");
        }
    }
    public static void main(String[] args) {
        try {
            connectToDatabase("jdbc:oracle:thin:@Tabassum-Yunus:1521:XE");
        } 
        catch (MyDBConnectionException e) {
            System.out.println(e.getMessage());
        }
    }
}











//public class W8Q1_NOPE {
//
//    public static void main(String[] args) {
//        String url = "jdbc:oracle:thin:@Tabassum-Yunus:1521:XE";        
//        String user = "system";             // Database credentials
//        String password = "system";
//
//        try {            
//            Class.forName("oracle.jdbc.driver.OracleDriver");       // Load the Oracle JDBC driver
//            try (Connection conn = DriverManager.getConnection(url, user, password)) {
//                System.out.println("Connected to the Oracle database successfully.");
//            }           
//        } 
//        catch (ClassNotFoundException e) {
//            System.out.println("Oracle JDBC Driver not found.");
//            
//        } 
//        catch (SQLException e) {
//            System.out.println("Connection to the Oracle database failed.");           
//        }
//    }
//}

