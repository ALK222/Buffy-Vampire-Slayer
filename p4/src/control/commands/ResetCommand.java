package control.commands;

import control.exceptions.CommandParseException;
import logic.Game;

/**
 * Command to reset the game to its initial state
 */
public class ResetCommand extends Command {

    private static String _name = "Reset";
    private static String _shortcut = "R";
    private static String _details = "[R]eset";
    private static String _help = "Reset the game.";

    /**
     * ResetCommand Constructor
     */
    public ResetCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) {
        game.reset();
        return true;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        try {
            return parseNoParamsCommand(commandWords);
        } catch (CommandParseException ex) {
            throw ex;
        }
    }

}
