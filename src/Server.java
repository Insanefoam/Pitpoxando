import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket player1;
    private Socket player2;
    private int[] board = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    public Server() {
        try (ServerSocket serverSocket = new ServerSocket(3555, 2, InetAddress.getLocalHost())) {
            //Start connections
            player1 = serverSocket.accept();
            System.out.println("Connection accepted for player 1. Waiting for second player...");
            System.out.println("IP address for connection: " + InetAddress.getLocalHost());
            player2 = serverSocket.accept();
            System.out.println("Connection accepted for player 2. Ready for game.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Server(boolean test){

    }

    public void start() throws Exception {
        DataInputStream playerOneInput;
        DataInputStream playerTwoInput;
        DataOutputStream playerOneOutput = null;
        DataOutputStream playerTwoOutput = null;
        boolean draw = true;
        try {
            //Get inputs and outputs
            playerOneInput = new DataInputStream(player1.getInputStream());
            playerTwoInput = new DataInputStream(player2.getInputStream());
            playerOneOutput = new DataOutputStream(player1.getOutputStream());
            playerTwoOutput = new DataOutputStream(player2.getOutputStream());
            //Game loop
            int intMovement = -1;
            int turn = 0;
            String movementPackage;
            while (!player1.isClosed() || !player2.isClosed()) {
                playerOneOutput.writeUTF("your");
                movementPackage = playerOneInput.readUTF();
                intMovement = Integer.parseInt(movementPackage);
                board[intMovement - 1] = 1;
                playerTwoOutput.writeUTF(movementPackage);
                if (checkForWin(board) != -1) {
                    draw = false;
                    break;
                }
                turn++;
                playerOneOutput.writeUTF("enemy");

                if (turn > 8) break;
                playerTwoOutput.writeUTF("your");
                movementPackage = playerTwoInput.readUTF();
                intMovement = Integer.parseInt(movementPackage);
                board[intMovement - 1] = 2;
                playerOneOutput.writeUTF(movementPackage);
                if (checkForWin(board) != -1) {
                    draw = false;
                    break;
                }
                turn++;
                playerTwoOutput.writeUTF("enemy");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //End game block
        try {
            if (draw) {
                playerOneOutput.writeUTF("draw");
                playerTwoOutput.writeUTF("draw");
                return;
            }
            playerOneOutput.writeUTF("end" + checkForWin(board));
            playerTwoOutput.writeUTF("end" + checkForWin(board));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nGame end");
        System.out.println("Player " + checkForWin(board) + " win");
    }

    public int checkForWin(int board[]) throws Exception{
        //Check all variants for win
        if(board == null || board.length == 0) throw  new Exception();
        if (board[0] == board[1] && board[0] == board[2]) return board[0];
        if (board[0] == board[3] && board[0] == board[6]) return board[0];
        if (board[1] == board[4] && board[1] == board[7]) return board[1];
        if (board[2] == board[5] && board[2] == board[8]) return board[2];
        if (board[3] == board[4] && board[3] == board[5]) return board[3];
        if (board[6] == board[7] && board[6] == board[8]) return board[6];
        if (board[0] == board[4] && board[0] == board[8]) return board[0];
        if (board[2] == board[4] && board[2] == board[6]) return board[2];
        return -1;
    }
}
