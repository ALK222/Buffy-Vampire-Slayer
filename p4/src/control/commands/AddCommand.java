package control.commands;

import control.exceptions.CommandParseException;
import logic.Game;

/**
 * Command to add a slayer to the board
 */
public class AddCommand extends Command {

    private static final String _name = "Add";
    private static final String _shortcut = "A";
    private static final String _details = "[A]dd <x> <y>";
    private static final String _help = "adds a slayer in position x, y.";

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
        if (game.addSlayer(_x, _y)) {
            game.update();
            return true;
        }
        return false;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if (!matchCommandName(commandWords[0])) {
            return null;
        } else if (commandWords.length != 3) {
            throw new CommandParseException("[ERROR]: Command " + _name + " : " + incorrectNumberOfArgsMsg);
        }
        try {
            int x = Integer.parseInt(commandWords[1]);
            int y = Integer.parseInt(commandWords[2]);

            return new AddCommand(x, y);
        } catch (NumberFormatException nfe) {
            System.out.println("[ERROR]: Command " + _name + ": " + nfe.getMessage());
            throw new CommandParseException("[ERROR]: Command " + _name + ": " + incorrectArgsMsg, nfe);
        }
    }
}
