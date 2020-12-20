package control.commands;

import control.exceptions.CommandExecuteException;
import control.exceptions.CommandParseException;
import logic.Game;

public class SaveCommand extends Command {

    private static final String _name = "Save";
    private static final String _shortcut = "S";
    private static final String _details = "[S]ave <filename>";
    private static final String _help = "Saves the game in its current state to a file with <filename>.dat.";

    private String _file;

    /**
     * AddCommand constructor without arguments for CommandGenerator
     */
    public SaveCommand() {
        super(_name, _shortcut, _details, _help);
    }

    /**
     * AddCommand constructor with coordinates
     * 
     * @param f file name
     */
    public SaveCommand(String f) {
        super(_name, _shortcut, _details, _help);
        _file = f;
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            game.save(_file);
        } catch (Exception e) {
            System.out.println(e);
            throw new CommandExecuteException("[ERROR]: failed to save the game", e);
        }
        return false;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if (!matchCommandName(commandWords[0])) {
            return null;
        } else if (commandWords.length != 2) {
            throw new CommandParseException("[ERROR]: Command " + _name + " : " + incorrectNumberOfArgsMsg);
        }
        return new SaveCommand(commandWords[1]);
    }
}
