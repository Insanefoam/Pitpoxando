import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PlayerTwoForLocal extends Thread {
    public String ip;

    @Override
    public void run() {
        try {
            new Player(2, InetAddress.getByName(ip));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
