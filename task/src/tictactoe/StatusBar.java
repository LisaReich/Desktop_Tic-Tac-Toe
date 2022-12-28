package tictactoe;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JPanel {
    private static JLabel labelStatus;
    private static GameState gameState = GameState.GAME_IS_NOT_STARTED;
    public StatusBar() {

        setLayout(new BorderLayout());

        // LabelStatus
        labelStatus = new JLabel();
        labelStatus.setName("LabelStatus");
        labelStatus.setText(GameState.GAME_IS_NOT_STARTED.getStringGameState());
        this.add(labelStatus, BorderLayout.WEST);

    }

    public static void updateStatus(GameState state) {
        setGameState(gameState);
        labelStatus.setText(state.getStringGameState());
    }

    public static GameState getGameState() {
        return Board.checkGameState();
    }

    public static void setGameState(GameState gameState) {
        StatusBar.gameState = gameState;
    }

}
