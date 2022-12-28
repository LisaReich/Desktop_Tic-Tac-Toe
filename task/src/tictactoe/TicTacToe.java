package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TicTacToe extends JFrame{
    public TicTacToe() {

        setLayout(new BorderLayout());

        JPanel status = new StatusBar();
        JPanel tools = new ToolBar();
        JPanel board = new Board();

        this.add(tools, BorderLayout.NORTH);
        this.add(status, BorderLayout.SOUTH);
        this.add(board, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setTitle("Tic Tac Toe");
        setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        JMenu MenuGame = new JMenu("Game");
        MenuGame.setMnemonic(KeyEvent.VK_G);

        JMenuItem MenuHumanHuman = new JMenuItem("Human vs Human");
        JMenuItem MenuHumanRobot = new JMenuItem("Human vs Robot");
        JMenuItem MenuRobotHuman = new JMenuItem("Robot vs Human");
        JMenuItem MenuRobotRobot = new JMenuItem("Robot vs Robot");
        JMenuItem MenuExit = new JMenuItem("Exit");

        // For JetBrains Testing System
        MenuGame.setName("MenuGame");
        MenuHumanHuman.setName("MenuHumanHuman");
        MenuHumanRobot.setName("MenuHumanRobot");
        MenuRobotHuman.setName("MenuRobotHuman");
        MenuRobotRobot.setName("MenuRobotRobot");
        MenuExit.setName("MenuExit");
        // The End of section

        MenuExit.addActionListener(e -> {
            System.exit(0);
        });

        MenuHumanHuman.addActionListener(e -> {
            ToolBar.buttonPlayer1.setText(Player.HUMAN.getName());
            ToolBar.buttonPlayer2.setText(Player.HUMAN.getName());
            prepareGameField();
        });

        MenuHumanRobot.addActionListener(e -> {
            ToolBar.buttonPlayer1.setText(Player.HUMAN.getName());
            ToolBar.buttonPlayer2.setText(Player.ROBOT.getName());
            prepareGameField();
        });

        MenuRobotHuman.addActionListener(e -> {
            ToolBar.buttonPlayer2.setText(Player.HUMAN.getName());
            ToolBar.buttonPlayer1.setText(Player.ROBOT.getName());
            prepareGameField();
        });

        MenuRobotRobot.addActionListener(e -> {
            ToolBar.buttonPlayer1.setText(Player.ROBOT.getName());
            ToolBar.buttonPlayer2.setText(Player.ROBOT.getName());
            prepareGameField();
        });

        MenuGame.add(MenuHumanHuman);
        MenuGame.add(MenuHumanRobot);
        MenuGame.add(MenuRobotHuman);
        MenuGame.add(MenuRobotRobot);

        MenuGame.addSeparator();
        MenuGame.add(MenuExit);

        menuBar.add(MenuGame);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public void prepareGameField() {
        ToolBar.setCurrentResetStartButtonMode();

        if (ToolBar.resetStartButton.getText().equals("Start")) {
            Board.reset();
            ToolBar.resetStartButton.doClick();
        } else {
            Board.start();
        }
    }
}