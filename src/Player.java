import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Player {
/*    public Player(int number) {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 3555)) {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            PlayerGUI gui = new PlayerGUI(number, outputStream);
            String temp;
            while (!socket.isClosed()) {
                temp = inputStream.readUTF();
                if (temp.equals("enemy")) {
                    gui.setMyTurn(false);
                    continue;
                }
                if (temp.equals("end1") || temp.equals("end2")) {
                    gui.setWin(temp);
                    break;
                }
                if (temp.equals("your")) {
                    gui.setMyTurn(true);
                    continue;
                }
                gui.setEnemyChoose(Integer.parseInt(temp) - 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public Player(int number, InetAddress inetAddress) {
        try (Socket socket = new Socket(inetAddress, 3555)) {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            PlayerGUI gui = new PlayerGUI(number, outputStream);
            String temp;
            while (!socket.isClosed()) {
                temp = inputStream.readUTF();
                if (temp.equals("enemy")) {
                    gui.setMyTurn(false);
                    continue;
                }
                if (temp.equals("end1") || temp.equals("end2") || temp.equals("draw")) {
                    gui.setWin(temp);
                    break;
                }
                if (temp.equals("your")) {
                    gui.setMyTurn(true);
                    continue;
                }
                gui.setEnemyChoose(Integer.parseInt(temp) - 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
