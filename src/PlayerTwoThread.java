import java.net.InetAddress;
import java.net.UnknownHostException;

public class PlayerTwoThread extends Thread{
    @Override
    public void run(){
        try {
            new Player(2, InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
