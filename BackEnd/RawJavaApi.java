import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RawJavaAPI {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Listen on port 8080

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept incoming connections

                // Read the HTTP request
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String line;
                while (!(line = reader.readLine()).isEmpty()) {
                    System.out.println(line);
                }

                // Prepare the HTTP response
                String response = "HTTP/1.1 200 OK\r\n\r\nHello, World!";
                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write(response.getBytes());

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
