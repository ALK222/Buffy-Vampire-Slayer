package control.commands;

import logic.Game;

/**
 * Exit command
 */
public class ExitCommand extends Command {

    private static String _name = "Exit";
    private static String _shortcut = "E";
    private static String _details = "[E]xit";
    private static String _help = "Exits the game";

    /**
     * Exitcommand constructor
     */
    public ExitCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) {
        game.exit();
        return false;
    }

    @Override
    public Command parse(String[] commandWords) {
        return parseNoParamsCommand(commandWords);
    }

}
