package control;

import java.util.Scanner;

import logic.Game;

public class Controller {

    // Atributos
    private Game _game;
    private Scanner _in;

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
    }

    // Metodos
    public void run() {
        String[] command;
        while (!_game.checkEnd()) {
            _game.printInfo();
            // Draw board
            System.out.print(prompt);
            command = _in.nextLine().toLowerCase().split(" ");
            _game.update();
        }
    }

    public void printGame() {
        System.out.println(_game);
    }

}
