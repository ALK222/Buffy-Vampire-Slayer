package control.commands;

import logic.Game;

public class ExitCommand extends Command {

    private static String _name = "Exit";
    private static String _shortcut = "E";
    private static String _details = "Exits the game";
    private static String _help = "Exits the game";

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
