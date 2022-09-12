import java.net.*;
import java.io.*;

public class MultiThreadServer {
    public static void main(String args[]) throws IOException {
        // Register service on port 1234
        ServerSocket s = new ServerSocket(1234);
        for(int i=1; i<8;i++){
            Socket connection=s.accept(); // Wait and accept a connection
            ClientServeThread cs = new ClientServeThread(connection,i);
            System.out.println("Client Number *** "+i+" ***");

            cs.start();
        }
    }
}
