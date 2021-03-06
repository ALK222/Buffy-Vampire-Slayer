package control.commands;

import control.exceptions.CommandExecuteException;
import control.exceptions.CommandParseException;
import logic.Game;

/**
 * Command to add BloodBanks to the board
 */
public class BloodBankCommand extends Command {

    private static final String _name = "Bank";
    private static final String _shortcut = "B";
    private static final String _details = "[B]ank <x> <y> <z>";
    private static final String _help = "adds a blood bank whit cost z in position x, y.";

    private int _x;
    private int _y;
    private int _cost;

    /**
     * BloodBankCommand constructor without arguments for CommandGenerator
     */
    public BloodBankCommand() {
        super(_name, _shortcut, _details, _help);
    }

    /**
     * BloodBankCommand constructor with coordinates
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public BloodBankCommand(int x, int y, int cost) {
        super(_name, _shortcut, _details, _help);
        _x = x;
        _y = y;
        _cost = cost;
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            game.addBloodBank(_x, _y, _cost);
            game.update();
            return true;
        } catch (CommandExecuteException e) {
            System.out.format(e.getMessage() + "%n%n");
            throw new CommandExecuteException("[ERROR]: Failed to add blood bank", e);
        }
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if (!matchCommandName(commandWords[0])) {
            return null;
        } else if (commandWords.length != 4) {
            throw new CommandParseException("[ERROR]: Command " + _name + ": " + incorrectArgsMsg);
        } else {
            try {
                int x = Integer.parseInt(commandWords[1]);
                int y = Integer.parseInt(commandWords[2]);
                int cost = Integer.parseInt(commandWords[3]);
                return new BloodBankCommand(x, y, cost);
            } catch (NumberFormatException nfe) {
                System.out.println("[ERROR]: Command " + _name + ": " + nfe.getMessage());
                throw new CommandParseException("[ERROR]: Command " + _name + ": " + incorrectArgsMsg, nfe);
            }
        }
    }
}
