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

    public static final String prompt = "Command > ";
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
        boolean refreshDisplay = true;

        while (!_game.checkEnd()) {

            if (refreshDisplay) {
                printGame();
            }
            refreshDisplay = false;

            System.out.print(prompt);
            String s = _in.nextLine();
            String[] parameters = s.toLowerCase().trim().split(" ");
            System.out.println("[DEBUG] Executing: " + s);
            Command command = CommandGenerator.parseCommand(parameters);
            if (command != null) {
                refreshDisplay = command.execute(_game);
            } else {
                System.out.println("[ERROR]: " + unknownCommandMsg);
            }
        }

        if (refreshDisplay)
            printGame();
        System.out.println("[Game over] " + _game.getFinalMsg());

    }

    /**
     * Prints the board of the game
     */
    public void printGame() {
        System.out.println(_printer);
    }

}
