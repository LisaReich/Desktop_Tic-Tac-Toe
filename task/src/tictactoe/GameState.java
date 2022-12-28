package tictactoe;

public enum GameState {
    GAME_IS_NOT_STARTED("Game is not started"),
    GAME_IN_PROGRESS("Game in progress"),
    X_TURN_PLAYER_HUMAN("The turn of Human Player (X)"),
    X_TURN_PLAYER_ROBOT("The turn of Robot Player (X)"),
    O_TURN_PLAYER_HUMAN("The turn of Human Player (O)"),
    O_TURN_PLAYER_ROBOT("The turn of Robot Player (O)"),
    X_WINS_HUMAN("The Human Player (X) wins"),
    X_WINS_ROBOT("The Robot Player (X) wins"),
    O_WINS_HUMAN("The Human Player (O) wins"),
    O_WINS_ROBOT("The Robot Player (O) wins"),
    DRAW("Draw");

    private final String stringGameState;

    GameState (String gameState) {
        this.stringGameState = gameState;
    }

    public String getStringGameState() {
        return stringGameState;
    }
}
