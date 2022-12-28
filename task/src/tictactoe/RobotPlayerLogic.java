package tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RobotPlayerLogic {

    public static int makeMove(String[] cells) {

        Random random = new Random(10);
        int randomNum = ThreadLocalRandom.current().nextInt(9);

        long emptyCells = Arrays.stream(cells).filter(" "::equals).count();

        String playerName = Board.getCurrentPlayer();

        // If a computer plays for X
        if ("X".equals(playerName)) {

            if (emptyCells == 9) {
                return 4;
            } else if (emptyCells == 7) {
                for (int i = 0; i < cells.length; i++) {
                    if ("O".equals(cells[1]) || "O".equals(cells[5])) { // "O" is on a side
                        return 6;
                    } else if ("O".equals(cells[3]) || "O".equals(cells[7])) { // "O" is on a side
                        return 2;
                    } else if ("O".equals(cells[0])) { // "O" is in a corner
                        return 8;
                    } else if ("O".equals(cells[8])) { // "O" is in a corner
                        return 0;
                    } else if ("O".equals(cells[2])) { // "O" is in a corner
                        return 6;
                    } else if ("O".equals(cells[6])) { // "O" is in a corner
                        return 2;
                    }
                }

            } else if (emptyCells == 5) {
                if ((checkWinPosition(cells, playerName) == -1)) {
                    for (int i = 0; i < cells.length; i++) {
                        if (("O".equals(cells[1]) && "O".equals(cells[2])
                                || ("O".equals(cells[3]) && "O".equals(cells[6])))
                                || ("O".equals(cells[2]) && "O".equals(cells[7]))
                                || ("O".equals(cells[2]) && "O".equals(cells[3]))) { // "O" is in a corner + side
                            return 0;
                        } else if (("O".equals(cells[5]) && "O".equals(cells[2]))
                                || ("O".equals(cells[6]) && "O".equals(cells[7]))
                                || ("O".equals(cells[6]) && "O".equals(cells[1]))
                                || ("O".equals(cells[6]) && "O".equals(cells[5]))) { // "O" is in a corner + side
                            return 8;
                        } else if ("O".equals(cells[0]) && "O".equals(cells[1])
                                || "O".equals(cells[5]) && "O".equals(cells[8])
                                || "O".equals(cells[0]) && "O".equals(cells[7])
                                || "O".equals(cells[8]) && "O".equals(cells[3])) { // "O" is in a corner + side
                            return 2;
                        } else if ("O".equals(cells[0]) && "O".equals(cells[3])
                                || "O".equals(cells[7]) && "O".equals(cells[8])
                                || "O".equals(cells[1]) && "O".equals(cells[8])
                                || "O".equals(cells[0]) && "O".equals(cells[5])) { // "O" is in a corner + side
                            return 6;
                        } else if ("O".equals(cells[0]) && "O".equals(cells[2])) { // "O"s are in two corners
                            return 1;
                        } else if ("O".equals(cells[0]) && "O".equals(cells[6])) { // "O"s are in two corners
                            return 3;
                        } else if ("O".equals(cells[2]) && "O".equals(cells[8])) { // "O"s are in two corners
                            return 5;
                        } else if ("O".equals(cells[6]) && "O".equals(cells[8])) { // "O"s are in two corners
                            return 7;
                        }
                    }
                } else {
                    return checkWinPosition(cells, playerName);
                }


            } else if (emptyCells == 3) {
                if ((checkWinPosition(cells, playerName) == -1)) {
                    for (int i = 0; i < cells.length; i++) {
                        if (" ".equals(cells[0])) {
                            return 0;
                        } else if (" ".equals(cells[2])) {
                            return 2;
                        } else if (" ".equals(cells[6])) {
                            return 6;
                        } else if (" ".equals(cells[8])) {
                            return 8;
                        }
                    }
                } else {
                    return checkWinPosition(cells, playerName);
                }


            } else if (emptyCells == 1) {
                for (int i = 0; i < cells.length; i++) {
                    if (" ".equals(cells[i])) {
                        return i;
                    }
                }
            }

        // If a computer plays for O
        } else if ("O".equals(playerName)) {
            if (emptyCells == 8) {

                if ("X".equals(cells[4])) {
                    while (randomNum == 1 || randomNum == 3 || randomNum == 5 || randomNum == 7 || randomNum == 4) {
                        randomNum = random.nextInt(9);
                    }
                    return randomNum;

                } else {
                    return 4;
                }


            } else if (emptyCells == 6) {
                if ((checkWinPosition(cells, "X") == -1)) {
                    while (randomNum == 1 || randomNum == 3 || randomNum == 5 || randomNum == 7 || randomNum == 4
                            || !" ".equals(cells[randomNum])) {
                        randomNum = random.nextInt(9);
                    }
                    return randomNum;

                } else {
                    return checkWinPosition(cells, "X");
                }

            } else if (emptyCells == 4 || emptyCells == 2) {
                if ((checkWinPosition(cells, playerName) == -1)) {
                    if ((checkWinPosition(cells, "X") == -1)) {
                        for (int i = 0; i < cells.length; i++) {
                            if (" ".equals(cells[i])) {
                                return i;
                            }
                        }
                    } else {
                        return checkWinPosition(cells, "X");
                    }

                } else return checkWinPosition(cells, playerName);

            }
        }

        return 4;
    }

    public static int checkWinPosition(String[] cells, String playerName) {

        // Check rows
        for (int i = 0; i < 3; i++) {
            int index = i * 3;
            if (" ".equals(cells[index]) && cells[index + 1].equals(cells[index + 2]) && cells[index + 1].equals(playerName)) {
                return index;
            } else if (" ".equals(cells[index + 1]) && cells[index].equals(cells[index + 2]) && cells[index].equals(playerName)) {
                return index + 1;
            } else if (" ".equals(cells[index + 2]) && cells[index].equals(cells[index + 1]) && cells[index].equals(playerName)) {
                return index + 2;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (" ".equals(cells[i]) && cells[i + 3].equals(cells[i + 6]) && cells[i + 3].equals(playerName)) {
                return i;
            } else if (" ".equals(cells[i + 3]) && cells[i].equals(cells[i + 6]) && cells[i].equals(playerName)) {
                return i + 3;
            } else if (" ".equals(cells[i + 6]) && cells[i].equals(cells[i + 3]) && cells[i].equals(playerName)) {
                return i + 6;
            }
        }

        // Check main diagonal
        if (" ".equals(cells[0]) && cells[4].equals(cells[8]) && cells[4].equals(playerName)) {
            return 0;
        } else if (" ".equals(cells[4]) && cells[0].equals(cells[8]) && cells[0].equals(playerName)) {
            return 4;
        } else if (" ".equals(cells[8]) && cells[0].equals(cells[4]) && cells[0].equals(playerName)) {
            return 8;
        }

        // Check side diagonal
        if (" ".equals(cells[2]) && cells[4].equals(cells[6]) && cells[4].equals(playerName)) {
            return 2;
        } else if (" ".equals(cells[4]) && cells[2].equals(cells[6]) && cells[2].equals(playerName)) {
            return 4;
        } else if (" ".equals(cells[6]) && cells[2].equals(cells[4]) && cells[2].equals(playerName)) {
            return 6;
        }

        return -1;
    }
}
