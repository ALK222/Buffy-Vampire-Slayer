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
            System.out.format(e.getMessage() + "%n%n");
            throw new CommandExecuteException("[ERROR]: Failed to add vampire", e);
        }
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if (!matchCommandName(commandWords[0])) {
            return null;
        } else if (commandWords.length < 3 && commandWords.length > 4) {
            throw new CommandParseException("[ERROR]: Command" + _name + " : " + incorrectNumberOfArgsMsg);
        }
        int pos = 0;
        VampType type = null;
        if (commandWords.length >= 4) {
            pos = 1; // changes the position of the coordinate position if a vampire type is given
            type = VampType.parse(parseVamp(commandWords[1].toUpperCase())); // changes the type of the vampire to the
                                                                             // given one
        }
        try {
            int x = Integer.parseInt(commandWords[pos + 1]);
            int y = Integer.parseInt(commandWords[pos + 2]);
            if (commandWords.length == 4) {

                if (type == null) {
                    throw new VampTypeException("[ERROR]: Command" + _name + ": " + VampType.getNotFoundMsg());
                } else {
                    return new AddVampireCommand(x, y, type);
                }
            } else {
                return new AddVampireCommand(x, y, VampType.NORMAL);
            }
        } catch (NumberFormatException | VampTypeException e) {
            System.out.println("[ERROR]: Command " + _name + ": " + e.getMessage());
            throw new CommandParseException("[ERROR]: Command " + _name + ": " + incorrectArgsMsg, e);
        }
    }

    /**
     * Parses the given string into the proper one acepted by the enum VampType
     * 
     * @param type string given
     * @return string accepted by the enum
     */
    private String parseVamp(String type) {
        switch (type) {
            case "D":
            case "DRACULA":
                return "Dracula";
            case "E":
            case "EXPLOSIVE":
                return "Explosive";
            case "N":
            case "NORMAL":
                return "Normal";
            default:
                return "";
        }
    }
}
