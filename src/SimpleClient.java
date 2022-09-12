/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.io.*;
public class SimpleClient {
    public static void main(String args[]) throws IOException {
        // Open your connection to a server, at port 1235
        Socket conn = new Socket("127.0.0.1",1235);
        // Get an input file handle from the socket and read the input
        DataInputStream dis =
                new DataInputStream(conn.getInputStream());
        String st = new String (dis.readUTF());
        System.out.println(st);
        // When done, just close the connection and exit
        dis.close();
        conn.close();
    }
}
