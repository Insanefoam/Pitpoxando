import java.net.InetAddress;
import java.net.UnknownHostException;

public class PlayerTwoForTest extends Thread {
    @Override
    public void run() {
        try {
            new Player(2, InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
