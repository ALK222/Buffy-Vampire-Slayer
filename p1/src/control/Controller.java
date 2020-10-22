package control;

import java.util.Scanner;

import logic.Game;
import view.GamePrinter;

/**
 * Controller of the game, checks for commands and checks for the game over
 */
public class Controller {

    // Attributes
    private Game _game;
    private Scanner _in;
    private GamePrinter _printer;
    private boolean _exit;

    public final String prompt = "Command > ";
    public static final String helpMsg = String.format(
            "Available commands:%n" + "[a]dd <x> <y>: add a slayer in position x, y%n" + "[h]elp: show this help%n"
                    + "[r]eset: reset game%n" + "[e]xit: exit game%n" + "[n]one | []: update%n");

    public static final String unknownCommandMsg = String.format("Unknown command");
    public static final String invalidCommandMsg = String.format("Invalid command");
    public static final String invalidPositionMsg = String.format("Invalid position");

    // Constructor
    public Controller(Game game, Scanner scanner) {
        _game = game;
        _in = scanner;
        _printer = new GamePrinter(_game, _game.getX(), _game.getY());
        _exit = false;
    }

    // Methods
    /**
     * Cycles of the game
     */
    public void run() {
        String[] command;
        while (!_game.checkEnd() && !_exit) {
            _game.printInfo();
            printGame();
            System.out.print(prompt);
            command = _in.nextLine().toLowerCase().split(" ");
            if (command[0].isEmpty() || selectCommand(command)) {
                _game.update();
            }
        }
        System.out.println(_game.getFinalMsg());
    }

    public void printGame() {
        System.out.println(_printer);
    }

    /**
     * Checks if the game should update after the command
     * 
     * @param c the command used in this cycle
     * @return true if the command updates the game, false if not
     */
    public boolean selectCommand(String[] c) {
        switch (c[0].charAt(0)) {
            case 'r':
                if (c.length == 1) {
                    _game.reset();
                    return false;
                } else {
                    System.out.println("Incorrect number of parameters, please try again");
                    return false;
                }
            case 'e':
                if (c.length == 1) {
                    _exit = true;
                    return false;
                } else {
                    System.out.println("Incorrect number of parameters, please try again");
                    return false;
                }
            case 'a':
                if (c.length == 3) {
                    boolean f = _game.addSlayer(Integer.parseInt(c[1]), Integer.parseInt(c[2]));
                    return f;
                } else {
                    System.out.println("Incorrect number of parameters, please try again");
                    return false;
                }
            case 'h':
                if (c.length == 1) {
                    System.out.println(helpMsg);
                    return false;
                } else {
                    System.out.println("Incorrect number of parameters, please try again");
                    return false;
                }
            default:
                System.out.println("Command not recognized, please try again");
                return false;
        }
    }
}
