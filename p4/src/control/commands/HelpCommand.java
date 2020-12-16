package control.commands;

import control.exceptions.CommandParseException;
import logic.Game;

/**
 * Command to show the list of commands and their use
 */
public class HelpCommand extends Command {

    private static String _name = "Help";
    private static String _shortcut = "H";
    private static String _details = "[H]";
    private static String _help = "Shows this help.";

    /**
     * HelpCommand constructor
     */
    public HelpCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) {
        System.out.println(CommandGenerator.commandHelp());
        return false;
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
