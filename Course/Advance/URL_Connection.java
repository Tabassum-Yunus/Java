package Week8;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

class NetworkConnectionException extends Exception {
    public NetworkConnectionException(String message) {
        super(message);
    }
}

class AutoClosable_HttpURLConnection implements AutoCloseable {
    
    private HttpURLConnection connection;

    public AutoClosable_HttpURLConnection(String urlString) throws NetworkConnectionException {
        try {
            URL url = new URL(urlString);
            this.connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new NetworkConnectionException("Failed to open connection");
        }
    }

    public HttpURLConnection getConnection() {
        return connection;
    }

    @Override
    public void close() {
        if (connection != null) {
            connection.disconnect();
            System.out.println("HttpURLConnection closed successfully.");
        }
    }
}

public class URL_Connection {
    public static void main(String[] args) throws NetworkConnectionException{
        String url = "http://www.goo_wededo_gle.com";
        try (AutoClosable_HttpURLConnection AutoURLCon = new AutoClosable_HttpURLConnection(url)) {
            HttpURLConnection HttpURLCon = AutoURLCon.getConnection();
            HttpURLCon.setRequestMethod("GET");

            int responseCode = HttpURLCon.getResponseCode();
            System.out.println("Response Code: " + responseCode);
        } 
        catch (IOException e) {
            throw new NetworkConnectionException("A network connection exception occurred: " + e.getMessage());
        } 
    }
}


