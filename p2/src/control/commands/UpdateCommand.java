package control.commands;

import logic.Game;

/**
 * Update command
 */
public class UpdateCommand extends Command {

    private static String _name = "Update";
    private static String _shortcut = "U";
    private static String _details = "[N]one | []";
    private static String _help = "Updates the game";

    /**
     * UpdateCommand constructor
     */
    public UpdateCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) {
        game.update();
        return true;
    }

    @Override
    public Command parse(String[] commandWords) {
        if (commandWords[0].equals("")) {
            return this;
        }
        return parseNoParamsCommand(commandWords);
    }

}
