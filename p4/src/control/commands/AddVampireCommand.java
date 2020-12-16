package control.commands;

import control.exceptions.CommandExecuteException;
import control.exceptions.CommandParseException;
import control.exceptions.VampTypeException;
import logic.Game;
import logic.VampType;

/**
 * Debug command to add vampires to the game
 */
public class AddVampireCommand extends Command {

    private static final String _name = "Vampire";
    private static final String _shortcut = "V";
    private static final String _details = "[V]ampire [<type>] <x> <y>";
    private static final String _help = "Type = {\"\"|\"V\"|\"D\"|\"E\"}: add a vampire in position x, y.";

    private int _x;
    private int _y;
    private VampType _type;

    /**
     * AddCommand constructor without arguments for CommandGenerator
     */
    public AddVampireCommand() {
        super(_name, _shortcut, _details, _help);
    }

    /**
     * AddVampireCommand constructor with coordinates
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public AddVampireCommand(int x, int y, VampType type) {
        super(_name, _shortcut, _details, _help);
        _x = x;
        _y = y;
        _type = type;
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            return game.addVampire(_x, _y, _type);
        } catch (CommandExecuteException e) {
            throw e;
        }
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if (!matchCommandName(commandWords[0])) {
            return null;
        } else if (commandWords.length <= 3 && commandWords.length >= 4) {
            throw new CommandParseException("[ERROR]: Command" + _name + " : " + incorrectNumberOfArgsMsg);
        }
        if (commandWords.length == 3) {
            try {
                int x = Integer.parseInt(commandWords[1]);
                int y = Integer.parseInt(commandWords[2]);
                return new AddVampireCommand(x, y, VampType.NORMAL);
            } catch (NumberFormatException nfe) {
                System.out.println("[ERROR]: Command " + _name + ": " + nfe.getMessage());
                throw new CommandParseException("[ERROR]: Command " + _name + ": " + incorrectArgsMsg, nfe);
            }
        } else if (commandWords.length == 4) {
            try {
                VampType type = VampType.parse(parseVamp(commandWords[1].toUpperCase()));
                if (type == null) {
                    throw new VampTypeException("[ERROR]: Command" + _name + ": " + VampType.getNotFoundMsg());
                }
                int x = Integer.parseInt(commandWords[2]);
                int y = Integer.parseInt(commandWords[3]);
                return new AddVampireCommand(x, y, type);
            } catch (NumberFormatException | VampTypeException e) {
                System.out.println("[ERROR]: Command " + _name + ": " + e.getMessage());
                throw new CommandParseException("[ERROR]: Command " + _name + ": " + incorrectArgsMsg, e);
            }
        }
        return null;
    }

    private String parseVamp(String type) {
        switch (type) {
            case "D":
                return "Dracula";
            case "E":
                return "Explosive";
            case "N":
                return "Normal";
            default:
                return "";
        }
    }
}
