package tictactoe;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JPanel {
    static JButton resetStartButton;
    static JButton buttonPlayer1;
    static JButton buttonPlayer2;

    public ToolBar() {

        setLayout(new BorderLayout());

        // StartResetButton
        resetStartButton = new JButton();
        resetStartButton.setText("Start");
        resetStartButton.setName("ButtonStartReset");
        resetStartButton.setForeground(Color.WHITE);
        resetStartButton.setFont(new Font("Arial", Font.BOLD, 10));
        resetStartButton.setBackground(Color.BLACK);
        resetStartButton.setPreferredSize(new Dimension(50, 20));
        resetStartButton.setFocusPainted(false);
        resetStartButton.addActionListener(e -> {

            setCurrentResetStartButtonMode();

            if (resetStartButton.getText().equals("Start")) {
                Board.reset();
            } else {
                Board.start();
            }
        });

        this.add(resetStartButton, BorderLayout.CENTER);

        // ButtonPlayer1
        buttonPlayer1 = new JButton();
        buttonPlayer1.setText(Player.HUMAN.getName());
        buttonPlayer1.setName("ButtonPlayer1");
        buttonPlayer1.setForeground(Color.BLACK);
        buttonPlayer1.setFont(new Font("Arial", Font.BOLD, 10));
        buttonPlayer1.setBackground(Color.WHITE);
        buttonPlayer1.setPreferredSize(new Dimension(95, 20));
        buttonPlayer1.setFocusPainted(false);
        buttonPlayer1.addActionListener(e -> {

            if (Player.HUMAN.getName().equals(buttonPlayer1.getText())) {
                buttonPlayer1.setText(Player.ROBOT.getName());
            } else {
                buttonPlayer1.setText(Player.HUMAN.getName());
            }

        });
        this.add(buttonPlayer1, BorderLayout.WEST);

        // ButtonPlayer2
        buttonPlayer2 = new JButton();
        buttonPlayer2.setText(Player.HUMAN.getName());
        buttonPlayer2.setName("ButtonPlayer2");
        buttonPlayer2.setForeground(Color.BLACK);
        buttonPlayer2.setFont(new Font("Arial", Font.BOLD, 10));
        buttonPlayer2.setBackground(Color.WHITE);
        buttonPlayer2.setPreferredSize(new Dimension(95, 20));
        buttonPlayer2.setFocusPainted(false);
        buttonPlayer2.addActionListener(e -> {

            if (Player.HUMAN.getName().equals(buttonPlayer2.getText())) {
                buttonPlayer2.setText(Player.ROBOT.getName());
            } else {
                buttonPlayer2.setText(Player.HUMAN.getName());
            }
        });
        this.add(buttonPlayer2, BorderLayout.EAST);
    }

    public static void setCurrentResetStartButtonMode() {
        if ("Reset".equals(resetStartButton.getText())) {
            resetStartButton.setText("Start");
        } else {
            resetStartButton.setText("Reset");
        }
    }

}
