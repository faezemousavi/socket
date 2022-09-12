
import java.net.*;
import java.io.*;
public class SimpleServer {
    public static void main(String args[]) throws InterruptedException {
        // Register service on port 1234
        try{
            ServerSocket s = new ServerSocket(1235);
            while(true) {
                System.out.println("+++++++++++++++++");
                Socket connection = s.accept(); // Wait and accept a connection
                System.out.println("**************");
                // Get a communication stream associated with the socket
                DataOutputStream dos =
                        new DataOutputStream(connection.getOutputStream());
                // Send a string!
                dos.writeUTF("Hi there");
                // Close the connection, but not the server socket
                dos.close();
                connection.close();
                Thread.sleep(19999);
            }
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());

        }
    }
}
