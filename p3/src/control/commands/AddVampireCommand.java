package control.commands;

import logic.Game;
import logic.VampType;

/**
 * Debug command to add vampires to the game
 */
public class AddVampireCommand extends Command {

    private static final String _name = "Vampire";
    private static final String _shortcut = "V";
    private static final String _details = "[V]ampire [<type>] <x> <y>";
    private static final String _help = "Type = {\"\"|\"D\"|\"E\"}: add a vampire in position x, y";

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
    public boolean execute(Game game) {
        if (game.addVampire(_x, _y, _type)) {
            game.update();
            return true;
        }
        return false;
    }

    @Override
    public Command parse(String[] commandWords) {
        if (!matchCommandName(commandWords[0])) {
            return null;
        } else if (commandWords.length <= 3 && commandWords.length >= 4) {
            System.out.println(Command.incorrectNumberOfArgsMsg);
            return null;
        }
        if (commandWords.length == 3) {
            try {
                int x = Integer.parseInt(commandWords[1]);
                int y = Integer.parseInt(commandWords[2]);
                return new AddVampireCommand(x, y, VampType.NORMAL);
            } catch (NumberFormatException nfe) {
                System.out.println("The arguments must be numers");
            }
            return null;
        } else if (commandWords.length == 4) {
            try {
                VampType type = VampType.parse(parseVamp(commandWords[1].toUpperCase()));
                int x = Integer.parseInt(commandWords[2]);
                int y = Integer.parseInt(commandWords[3]);
                if (type == null) {
                    System.out.println("Vampire type not supported");
                    return null;
                }
                return new AddVampireCommand(x, y, type);
            } catch (NumberFormatException nfe) {
                System.out.println("The arguments must be numers");
            }
            return null;
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
