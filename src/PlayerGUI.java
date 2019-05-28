import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.IOException;

public class PlayerGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField[] fields = {textField1, textField2, textField3,
            textField4, textField5, textField6,
            textField7, textField8, textField9};
    private String playerText;
    private String enemyText;
    private DataOutputStream outputStream;
    private boolean myTurn = false;

    public PlayerGUI(int player, DataOutputStream outputStream) {
        playerText = player == 1 ? "X" : "O";
        enemyText = playerText.equals("X") ? "O" : "X";
        this.outputStream = outputStream;
        this.setTitle("Player " + player);
        textField10.setText(player == 1 ? "Your turn" : "Enemy turn");
        add(mainPanel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addListeners();
        setVisible(true);
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
        textField10.setText(myTurn ? "Your turn" : "Enemy turn");
    }

    public void setWin(String winer) {
        if (winer.equals("end1")) textField10.setText("Player one win");
        if (winer.equals("end2")) textField10.setText("Player two win");
        if (winer.equals("draw")) textField10.setText("DRAW");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPanel.removeAll();
    }

    void addListeners() {
        textField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (myTurn) {
                    textField1.setText(playerText);
                    try {
                        outputStream.writeUTF("1");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        textField2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (myTurn) {
                    textField2.setText(playerText);
                    try {
                        outputStream.writeUTF("2");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        textField3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (myTurn) {

                    textField3.setText(playerText);
                    try {
                        outputStream.writeUTF("3");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        textField4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (myTurn) {

                    textField4.setText(playerText);
                    try {
                        outputStream.writeUTF("4");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        textField5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (myTurn) {
                    textField5.setText(playerText);
                    try {
                        outputStream.writeUTF("5");

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        textField6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (myTurn) {
                    textField6.setText(playerText);
                    try {
                        outputStream.writeUTF("6");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        textField7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (myTurn) {
                    textField7.setText(playerText);
                    try {
                        outputStream.writeUTF("7");

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        textField8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (myTurn) {
                    textField8.setText(playerText);
                    try {
                        outputStream.writeUTF("8");

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        textField9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (myTurn) {
                    textField9.setText(playerText);
                    try {
                        outputStream.writeUTF("9");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    void setEnemyChoose(int pos) {
        fields[pos].setText(enemyText);
    }
}
