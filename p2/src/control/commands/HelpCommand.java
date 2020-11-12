package control.commands;

import logic.Game;

/**
 * Help command
 */
public class HelpCommand extends Command {

    private static String _name = "Help";
    private static String _shortcut = "H";
    private static String _details = "Shows help";
    private static String _help = "Shows the help message of all the commands";

    public HelpCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) {
        System.out.println(CommandGenerator.commandHelp());
        return false;
    }

    @Override
    public Command parse(String[] commandWords) {
        return parseNoParamsCommand(commandWords);
    }

}
