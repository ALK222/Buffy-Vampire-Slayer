package control.commands;

import logic.Game;

public class ResetCommand extends Command {

    private static String _name = "Reset";
    private static String _shortcut = "R";
    private static String _details = "Resets the game";
    private static String _help = "Resets the game";

    public ResetCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) {
        game.reset();
        return false;
    }

    @Override
    public Command parse(String[] commandWords) {
        return parseNoParamsCommand(commandWords);
    }

}
