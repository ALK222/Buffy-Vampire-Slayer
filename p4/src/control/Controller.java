package control;

import java.util.Scanner;

import control.commands.Command;
import control.commands.CommandGenerator;
import logic.Game;
import view.PrinterType;

/**
 * Controller of the game, checks for commands and checks for the game state
 */
public class Controller {

    // Attributes
    private Game _game;
    private Scanner _in;
    private PrinterType _printer;

    public static final String prompt = "Command > "; // Prompt string used to ask for a command

    // Constructor
    public Controller(Game game, Scanner scanner) {
        _game = game;
        _in = scanner;
        _printer = PrinterType.BOARDPRINTER;
        _printer.setGame(_game);
        _game.setCtrl(this);
    }

    // Methods
    /**
     * Runner of the game, runs cycle until the game ends
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
        System.out.println(_printer.printGame());
    }

    /**
     * Changes the type of printer being used
     */
    public void serialize() {

        if (_printer == PrinterType.BOARDPRINTER) {
            _printer = PrinterType.STRINGIFIER;

        } else {
            _printer = PrinterType.BOARDPRINTER;
        }
        _printer.setGame(_game);
    }
}
