import java.net.*;
import java.io.*;

public class ClientServeThread extends Thread{
    private Socket s1;
    private int number;
    public ClientServeThread(Socket ts1, int number){
        s1 = ts1;
        this.number = number;
    }
    public void run () {

        try{
// Get a communication stream associated with the socket
            System.out.println("Thread Client #"+number+"  was started ...");
            OutputStream s1out = s1.getOutputStream();
            DataOutputStream dos = new DataOutputStream (s1out);
            // Send a string!
            dos.writeUTF("\nHi there \n your ID is = "+number+" \n");

            // Get an input file handle from the socket and read the input
            InputStream s1In = s1.getInputStream();
            DataInputStream dis = new DataInputStream(s1In);
            String st;

            for (int i=0; i<10; i++){
                st = new String (dis.readUTF());
                System.out.println("\n Message From Client #"+number+": ( "+st+" ) \n");
            }

            // Close the connection, but not the server socket
            dos.close();
            s1out.close();
            dis.close();
            s1In.close();


            s1.close();

            System.out.println("\n Thread Client #"+number+"  was finished ...");

        } catch(IOException e){
//
        }
    }

}
