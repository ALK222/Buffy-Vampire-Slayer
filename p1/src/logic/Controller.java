package Logic;

import java.util.Scanner;

public class Controller {

    // Atributos
    private Game _game;
    private Scanner _in;

    // Constructor
    public Controller(Game g) {
        _game = g;
        _in = new Scanner(System.in);
    }

    // Metodos
    public void run() {
        String[] command;
        while (!_game.checkEnd()) {
            _game.printInfo();
            // Draw board
            System.out.print("Command > ");
            command = _in.nextLine().toLowerCase().split(" ");
            _game.update();
        }
    }

}
