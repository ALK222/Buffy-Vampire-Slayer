package control;

import java.util.Scanner;

import control.commands.Command;
import control.commands.CommandGenerator;
import control.exceptions.CommandExecuteException;
import logic.Game;
import view.BoardPrinter;
import view.GamePrinter;
import view.Stringifier;

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
        _printer = new BoardPrinter(_game);
    }

    // Methods
    /**
     * Cycles of the game
     * 
     * @throws Exception
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
            try {
                Command command = CommandGenerator.parseCommand(parameters);
                refreshDisplay = command.execute(_game);
            } catch (Exception e) {
                System.out.format(e.getMessage() + "%n%n");
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

    public void setPrintMode(String mode) throws CommandExecuteException {

        switch (mode) {

            case "stringify":
            case "s":
                _printer = new Stringifier(_game);
                break;
            case "board":
            case "b":
                this._printer = new BoardPrinter(_game);
                break;
            default:
                throw new CommandExecuteException(
                        "[ERROR]: Unknown print mode. Avaliable modes are < stringify (s) | board (b) >.\n");

        }

    }

}
