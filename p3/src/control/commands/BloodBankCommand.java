package control.commands;

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
    public boolean execute(Game game) {
        if (game.addBloodBank(_x, _y, _cost)) {
            game.update();
            return true;
        }
        return false;
    }

    @Override
    public Command parse(String[] commandWords) {
        if (!matchCommandName(commandWords[0])) {
            return null;
        } else if (commandWords.length != 4) {
            return null;
        } else {
            try {
                int x = Integer.parseInt(commandWords[1]);
                int y = Integer.parseInt(commandWords[2]);
                int cost = Integer.parseInt(commandWords[3]);
                return new BloodBankCommand(x, y, cost);
            } catch (NumberFormatException nfe) {
                return null;
            }
        }
    }
}
