import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {
    private JPanel mainPanel;
    private JTextField chooseAnyOptionTextField;
    private JRadioButton startAsSecondPlayerRadioButton;
    private JRadioButton startTestRadioButton;
    private JRadioButton startAsServerRadioButton;
    private JButton submitButton;
    private JTextField enterServerIpRightTextField;
    public int mode = -1;
    private int subMode = -1;
    public String ip = "";

    public Menu() {
        add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        addListeners();
    }

    private void addListeners() {
        startAsSecondPlayerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTestRadioButton.setSelected(false);
                startAsServerRadioButton.setSelected(false);
                enterServerIpRightTextField.setEnabled(true);
                subMode = 2;
            }
        });

        startTestRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAsSecondPlayerRadioButton.setSelected(false);
                startAsServerRadioButton.setSelected(false);
                enterServerIpRightTextField.setEnabled(false);
                subMode = 3;
            }
        });

        startAsServerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTestRadioButton.setSelected(false);
                startAsSecondPlayerRadioButton.setSelected(false);
                enterServerIpRightTextField.setEnabled(false);
                subMode = 1;
            }
        });

        enterServerIpRightTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (enterServerIpRightTextField.isEnabled()) {
                    enterServerIpRightTextField.setText("");
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mode = subMode;
                ip = enterServerIpRightTextField.getText();
                dispose();
            }
        });
    }
}
