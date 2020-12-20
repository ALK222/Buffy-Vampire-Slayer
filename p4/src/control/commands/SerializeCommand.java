package control.commands;

import control.exceptions.CommandExecuteException;
import control.exceptions.CommandParseException;
import logic.Game;

public class SerializeCommand extends Command {

    private static final String _name = "Serialize";
    private static final String _shortcut = "S";
    private static final String _details = "[S]erialize";
    private static final String _help = "changes the view between serialize and board.";

    public SerializeCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        game.serialize();
        return true;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        return parseNoParamsCommand(commandWords);
    }

}
