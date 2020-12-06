package control.commands;

import logic.Game;

/**
 * Command to execute a GarlicPush attack
 */
public class GarlicPushCommand extends Command {

    private static String _name = "Garlic";
    private static String _shortcut = "G";
    private static String _details = "[G]arlic";
    private static String _help = "Pushes back vampires.";

    /**
     * GarlicPushCommand constructor
     */
    public GarlicPushCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) {
        return game.garlicPush();
    }

    @Override
    public Command parse(String[] commandWords) {
        return parseNoParamsCommand(commandWords);
    }

}
