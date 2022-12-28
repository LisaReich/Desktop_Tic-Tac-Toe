package tictactoe;

import javax.swing.*;
import java.awt.*;

public class BoardButton extends JButton {
    boolean occupied = false;
    public BoardButton(String name) {
        setName(String.format("Button%s",name));
        setText(" ");
        setBackground(Color.ORANGE);
        setFont(new Font("Arial", Font.BOLD, 40));
        setFocusPainted(false);
        setEnabled(false);

        this.addActionListener(e -> {

            if (!isOccupied() && Board.isGameStarted()) {
                if ((Player.HUMAN.getName().equals(ToolBar.buttonPlayer1.getText()) &&
                        Player.ROBOT.getName().equals(ToolBar.buttonPlayer2.getText())) ||
                        (Player.ROBOT.getName().equals(ToolBar.buttonPlayer1.getText()) &&
                                Player.HUMAN.getName().equals(ToolBar.buttonPlayer2.getText()))) {

                    this.setText(Board.getCurrentPlayerAndChange());
                    this.occupied = true;
                    BoardButton btn = Board.playRobot();

                    btn.setText(Board.getCurrentPlayerAndChange());
                    btn.occupied = true;


                } else if (Player.HUMAN.getName().equals(ToolBar.buttonPlayer1.getText()) &&
                        Player.HUMAN.getName().equals(ToolBar.buttonPlayer2.getText())) {
                    this.setText(Board.getCurrentPlayerAndChange());
                    this.occupied = true;
                }
            }


            GameState currentGameState = Board.checkGameState();
            StatusBar.updateStatus(currentGameState);
            Board.checkStopGame();

        });

    }

    public boolean isOccupied() {
        return occupied;
    }

    public void reset() {
        this.setText(" ");
        occupied = false;
        this.setEnabled(false);
        ToolBar.buttonPlayer1.setEnabled(true);
        ToolBar.buttonPlayer2.setEnabled(true);
    }

    public void start() {
        this.setEnabled(true);
        ToolBar.buttonPlayer1.setEnabled(false);
        ToolBar.buttonPlayer2.setEnabled(false);
    }
}
