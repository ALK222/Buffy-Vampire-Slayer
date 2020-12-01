package control.commands;

import logic.Game;

/**
 * Reset command
 */
public class ResetCommand extends Command {

    private static String _name = "Reset";
    private static String _shortcut = "R";
    private static String _details = "[R]eset";
    private static String _help = "Resets the game";

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
    public Command parse(String[] commandWords) {
        return parseNoParamsCommand(commandWords);
    }

}
