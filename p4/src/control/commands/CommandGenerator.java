package control.commands;

import control.exceptions.CommandParseException;

/**
 * Command builder
 */
public class CommandGenerator {

    /**
     * List of all commands in the game
     */
    private static Command[] availableCommands = { new AddCommand(), new AddVampireCommand(), new BloodBankCommand(),
            new ExitCommand(), new GarlicPushCommand(), new HelpCommand(), new LightFlashCommand(), new ResetCommand(),
            new SuperCoinsCommand(), new UpdateCommand() };

    public static String commandHelp() {
        // shows al commands
        String show = "The available commands are:" + System.getProperty("line.separator");

        for (int i = 0; i < availableCommands.length; i++) {
            show += availableCommands[i].helpText();
            show += System.getProperty("line.separator");
        }
        return show;
    }

    public static Command parseCommand(String[] commandWords) throws Exception {
        // parse commands
        int i = 0;
        boolean ok = false;
        try {
            while (!ok && i < availableCommands.length) {
                if (availableCommands[i].parse(commandWords) == null) {
                    i++;
                } else {
                    return availableCommands[i].parse(commandWords);
                }
            }
            if (!ok) {
                ;
            }
        } catch (Exception ex) {
            throw ex;
        }
        throw new CommandParseException("[ERROR]: CommandGerenator: command not found");
    }

}
