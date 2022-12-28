package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    private static boolean gameStarted = false;
    private static final ArrayList<BoardButton> buttons = new ArrayList<>();
    private static String currentPlayer = "X";
    public Board() {

        setLayout(new GridLayout(3, 3, 5, 5));

        for (ButtonEnum btn : ButtonEnum.values()) {
            BoardButton jbtn = new BoardButton(btn.name());
            buttons.add(jbtn);
            this.add(jbtn);
        }
    }

    public static String getCurrentPlayerAndChange() {
        if ("X".equals(currentPlayer)) {
            currentPlayer = "O";
            return "X";
        } else {
            currentPlayer = "X";
            return "O";
        }
    }

    public static String getCurrentPlayer() {
        return currentPlayer;
    }

    public static void reset() {
        for (BoardButton button : buttons) {
            button.reset();
        }

        gameStarted = false;
        StatusBar.updateStatus(GameState.GAME_IS_NOT_STARTED);
    }

    public static void start() {
        for (BoardButton button : buttons) {
            button.start();
        }

        currentPlayer = "X";

        if (Player.ROBOT.getName().equals(ToolBar.buttonPlayer1.getText())) {
            StatusBar.updateStatus(GameState.X_TURN_PLAYER_ROBOT);
        } else {
            StatusBar.updateStatus(GameState.X_TURN_PLAYER_HUMAN);
        }

        gameStarted = true;

        // First move of the ROBOT
        if (Player.ROBOT.getName().equals(ToolBar.buttonPlayer1.getText()) &&
                Player.HUMAN.getName().equals(ToolBar.buttonPlayer2.getText())) {

            BoardButton btn = Board.playRobot();
            btn.setText(Board.getCurrentPlayerAndChange());
            btn.occupied = true;

            GameState currentGameState = checkGameState();
            StatusBar.updateStatus(currentGameState);

        } else if (Player.ROBOT.getName().equals(ToolBar.buttonPlayer1.getText()) &&
                Player.ROBOT.getName().equals(ToolBar.buttonPlayer2.getText())) {

            while (!checkStopGame()) {

                BoardButton btn = Board.playRobot();
                btn.setText(Board.getCurrentPlayerAndChange());
                btn.occupied = true;

                GameState currentGameState = checkGameState();
                StatusBar.updateStatus(currentGameState);
            }
        }
    }

    public static boolean isGameStarted() {
        return gameStarted;
    }

    public static boolean checkStopGame() {
        if (StatusBar.getGameState() == GameState.X_WINS_HUMAN ||
                StatusBar.getGameState() == GameState.X_WINS_ROBOT ||
                StatusBar.getGameState() == GameState.O_WINS_HUMAN ||
                StatusBar.getGameState() == GameState.O_WINS_ROBOT ||
                StatusBar.getGameState() == GameState.DRAW) {

            for (BoardButton button : buttons) {
                button.setEnabled(false);
            }
            return true;
        }
        return false;
    }

    public static GameState checkGameState() {
        String[] cells = new String[9];

        for (int i = 0; i < cells.length; i++) {
            cells[i] = buttons.get(i).getText();
        }

        return GameLogic.getGameState(cells);
    }

    public static BoardButton playRobot() {

        String[] cells = new String[9];

        for (int i = 0; i < cells.length; i++) {
            cells[i] = buttons.get(i).getText();
        }

        return buttons.get(RobotPlayerLogic.makeMove(cells));
    }
}
