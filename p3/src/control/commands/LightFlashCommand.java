package control.commands;

import logic.Game;

/**
 * Command to execute a LightFlash Command
 */
public class LightFlashCommand extends Command {
    private static String _name = "Light";
    private static String _shortcut = "L";
    private static String _details = "[L]ight";
    private static String _help = "Kills all the vampires.";

    /**
     * LightFlashCommand constructor
     */
    public LightFlashCommand() {
        super(_name, _shortcut, _details, _help);
    }

    @Override
    public boolean execute(Game game) {
        return game.lightFlash();
    }

    @Override
    public Command parse(String[] commandWords) {
        return parseNoParamsCommand(commandWords);
    }
}
