import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by Mehdi_2 on 03/03/2019.
 */
//Multicast Sender
public class MulticastServer {
    public static void main(String[] args) {
        try {
            MulticastSocket ms = new MulticastSocket(4000);
            InetAddress ia = InetAddress.getByName("224.2.2.2");
            ms.joinGroup(ia);

            //InetAddress ia = InetAddress.getByName("experiment.mcast.net");
            byte[] data;// = "Here's some multicast data\r\n".getBytes();
            int port = 4000;
            //MulticastSocket ms = new MulticastSocket();
            int i=0;
            while(true) {
                data = ("Here's some multicast data. iter="+i+"\r\n").getBytes();
                DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
                //ms.setTimeToLive(64);
                ms.send(dp);
                i++;
                Thread.sleep(1000);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
