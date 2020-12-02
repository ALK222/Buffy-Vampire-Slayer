package control.commands;

import logic.Game;

/**
 * Debug command to add 100 coins to the player
 */
public class SuperCoinsCommand extends Command {

    private static int _COINS = 100;
    private static String _name = "Coins";
    private static String _shortcut = "C";
    private static String _details = "[C]oins";
    private static String _help = "adds " + _COINS + " coins to the player";

    /**
     * SuperCoinsCommand constructor
     */
    public SuperCoinsCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) {
        game.addCoins(_COINS);
        return false;
    }

    @Override
    public Command parse(String[] commandWords) {
        return parseNoParamsCommand(commandWords);
    }

}
