package control.commands;

import logic.Game;

/**
 * Command to add a slayer to the board
 */
public class AddCommand extends Command {

    private static final String _name = "Add";
    private static final String _shortcut = "A";
    private static final String _details = "Adds a slayer to the field";
    private static final String _help = "[A]dd <x> <y>: adds a slayer to the given coordinates";

    private int _x;
    private int _y;

    /**
     * AddCommand constructor without arguments for CommandGenerator
     */
    public AddCommand() {
        super(_name, _shortcut, _details, _help);
    }

    /**
     * AddCommand constructor with coordinates
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public AddCommand(int x, int y) {
        super(_name, _shortcut, _details, _help);
        _x = x;
        _y = y;
    }

    @Override
    public boolean execute(Game game) {
        return game.addSlayer(_x, _y);
    }

    @Override
    public Command parse(String[] commandWords) {
        if (!matchCommandName(commandWords[0])) {
            return null;
        } else if (commandWords.length != 3) {
            System.out.println(Command.incorrectNumberOfArgsMsg);
            return null;
        }
        return new AddCommand(Integer.parseInt(commandWords[1]), Integer.parseInt(commandWords[2]));
    }
}
