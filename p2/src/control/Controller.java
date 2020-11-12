package control;

import java.util.Scanner;

import control.commands.Command;
import control.commands.CommandGenerator;
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
    }

    // Methods
    /**
     * Cycles of the game
     */
    public void run() {
        _game.printInfo();
        printGame();
        while (!_game.checkEnd()) {
            System.out.print(prompt);
            String[] commandWords = _in.nextLine().toLowerCase().split(" ");
            Command c = CommandGenerator.parseCommand(commandWords);
            if (c != null) {
                if (c.execute(_game)) {
                    _game.update();
                    _game.printInfo();
                    printGame();
                }
            }
        }
        System.out.println(_game.getFinalMsg());
    }

    public void printGame() {
        System.out.println(_printer);
    }

}
