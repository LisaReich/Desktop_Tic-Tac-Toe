package tictactoe;

import java.util.Arrays;

public class GameLogic {

    public static GameState getGameState(String[] cells) {

        // Check rows
        for (int i = 0; i < 3; i++) {
            int index = i * 3;
            if (!" ".equals(cells[index]) && cells[index].equals(cells[index + 1]) && cells[index].equals(cells[index + 2])) {
                if ("X".equals(cells[index]) && Player.ROBOT.getName().equals(ToolBar.buttonPlayer1.getText())) {
                    return GameState.X_WINS_ROBOT;
                } else if ("X".equals(cells[index]) && Player.HUMAN.getName().equals(ToolBar.buttonPlayer1.getText())) {
                    return GameState.X_WINS_HUMAN;
                } else if ("O".equals(cells[index]) && Player.ROBOT.getName().equals(ToolBar.buttonPlayer2.getText())) {
                    return GameState.O_WINS_ROBOT;
                } else if ("O".equals(cells[index]) && Player.HUMAN.getName().equals(ToolBar.buttonPlayer2.getText())) {
                    return GameState.O_WINS_HUMAN;
                }
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (!" ".equals(cells[i]) && cells[i].equals(cells[i + 3]) && cells[i].equals(cells[i + 6])) {
                if ("X".equals(cells[i]) && Player.ROBOT.getName().equals(ToolBar.buttonPlayer1.getText())) {
                    return GameState.X_WINS_ROBOT;
                } else if ("X".equals(cells[i]) && Player.HUMAN.getName().equals(ToolBar.buttonPlayer1.getText())) {
                    return GameState.X_WINS_HUMAN;
                } else if ("O".equals(cells[i]) && Player.ROBOT.getName().equals(ToolBar.buttonPlayer2.getText())) {
                    return GameState.O_WINS_ROBOT;
                } else if ("O".equals(cells[i]) && Player.HUMAN.getName().equals(ToolBar.buttonPlayer2.getText())) {
                    return GameState.O_WINS_HUMAN;
                }
            }
        }

        // Check main diagonal
        if (!" ".equals(cells[0]) && cells[0].equals(cells[4]) && cells[0].equals(cells[8])) {
            if ("X".equals(cells[0]) && Player.ROBOT.getName().equals(ToolBar.buttonPlayer1.getText())) {
                return GameState.X_WINS_ROBOT;
            } else if ("X".equals(cells[0]) && Player.HUMAN.getName().equals(ToolBar.buttonPlayer1.getText())) {
                return GameState.X_WINS_HUMAN;
            } else if ("O".equals(cells[0]) && Player.ROBOT.getName().equals(ToolBar.buttonPlayer2.getText())) {
                return GameState.O_WINS_ROBOT;
            } else if ("O".equals(cells[0]) && Player.HUMAN.getName().equals(ToolBar.buttonPlayer2.getText())) {
                return GameState.O_WINS_HUMAN;
            }
        }

        // Check side diagonal
        if (!" ".equals(cells[2]) && cells[2].equals(cells[4]) && cells[2].equals(cells[6])) {
            if ("X".equals(cells[2]) && Player.ROBOT.getName().equals(ToolBar.buttonPlayer1.getText())) {
                return GameState.X_WINS_ROBOT;
            } else if ("X".equals(cells[2]) && Player.HUMAN.getName().equals(ToolBar.buttonPlayer1.getText())) {
                return GameState.X_WINS_HUMAN;
            } else if ("O".equals(cells[2]) && Player.ROBOT.getName().equals(ToolBar.buttonPlayer2.getText())) {
                return GameState.O_WINS_ROBOT;
            } else if ("O".equals(cells[2]) && Player.HUMAN.getName().equals(ToolBar.buttonPlayer2.getText())) {
                return GameState.O_WINS_HUMAN;
            }
        }

        // Check draw
        if (Arrays.stream(cells).noneMatch(" "::equals)) {
            return GameState.DRAW;
        }

        // Check if Game started
        if (Arrays.stream(cells).allMatch(" "::equals)) {
            return GameState.GAME_IS_NOT_STARTED;
        }

        if (Player.ROBOT.getName().equals(ToolBar.buttonPlayer1.getText())
                && "X".equals(Board.getCurrentPlayer())) {
            return GameState.X_TURN_PLAYER_ROBOT;
        } else if (Player.HUMAN.getName().equals(ToolBar.buttonPlayer1.getText())
                && "X".equals(Board.getCurrentPlayer())) {
            return GameState.X_TURN_PLAYER_HUMAN;
        } else if (Player.ROBOT.getName().equals(ToolBar.buttonPlayer2.getText())
                && "O".equals(Board.getCurrentPlayer())) {
            return GameState.O_TURN_PLAYER_ROBOT;
        } else if (Player.HUMAN.getName().equals(ToolBar.buttonPlayer2.getText())
                && "O".equals(Board.getCurrentPlayer())) {
            return GameState.O_TURN_PLAYER_HUMAN;
        }

        return GameState.GAME_IN_PROGRESS;
    }
}
