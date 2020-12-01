package control.commands;

public class CommandGenerator {

    /**
     * List of all commands in the game
     */
    private static Command[] availableCommands = { new AddCommand(), new HelpCommand(), new ResetCommand(),
            new ExitCommand(), new UpdateCommand(), new GarlicPushCommand(), new LightFlashCommand(),
            new SuperCoinsCommand(), new AddVampireCommand() };

    public static String commandHelp() {
        // shows al commands
        String show = "The available commands are:" + System.getProperty("line.separator");

        for (int i = 0; i < availableCommands.length; i++) {
            show += availableCommands[i].helpText();
            show += System.getProperty("line.separator");
        }
        return show;
    }

    public static Command parseCommand(String[] commandWords) {
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
        return null;
    }

}
