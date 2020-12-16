package control.commands;

import control.exceptions.CommandExecuteException;
import control.exceptions.CommandParseException;
import logic.Game;

/**
 * Command to execute a LightFlash Command
 */
public class LightFlashCommand extends Command {
    private static String _name = "Light";
    private static String _shortcut = "L";
    private static String _details = "[L]ight";
    private static String _help = "Kills all the vampires.";

    /**
     * LightFlashCommand constructor
     */
    public LightFlashCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            return game.lightFlash();
        } catch (CommandExecuteException e) {
            System.out.format(e.getMessage() + "%n%n");
            throw new CommandExecuteException("[ERROR]: Failed execute a Light flash", e);
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
