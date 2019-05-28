import java.net.InetAddress;
import java.net.UnknownHostException;

public class PlayerOneThread extends Thread{
    @Override
    public void run(){
        try {
            new Player(1, InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
