package control.commands;

import control.exceptions.CommandExecuteException;
import control.exceptions.CommandParseException;
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
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            return game.garlicPush();
        } catch (CommandExecuteException e) {
            System.out.format(e.getMessage() + "%n%n");
            throw new CommandExecuteException("[ERROR]: Failed execute a garlic push", e);
        }

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
