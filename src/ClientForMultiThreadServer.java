import java.net.*;
import java.io.*;

public class ClientForMultiThreadServer {
    public static void main(String args[]) throws IOException, InterruptedException {
        // Open your connection to a server, at port 1234
        Socket s1 = new Socket("127.0.0.1",1234);
        // Get an input file handle from the socket and read the input
        InputStream s1In = s1.getInputStream();
        DataInputStream dis = new DataInputStream(s1In);
        String st = new String (dis.readUTF());
        System.out.println(st);

        OutputStream s1out = s1.getOutputStream();
        DataOutputStream dos = new DataOutputStream (s1out);

        for (int i=0; i<10; i++){
            // Send a string!
            dos.writeUTF("****Hi there****");
            Thread.sleep(4000);
        }

        dos.close();
        s1out.close();
        dis.close();
        s1In.close();

        s1.close();
    }
}
