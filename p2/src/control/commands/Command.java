package control.commands;

import logic.Game;

public abstract class Command {
    protected final String name;
    protected final String shortcut;
    private final String details;
    private final String help;
    protected static final String incorrectNumberOfArgsMsg = "Incorrect number ofarguments";
    protected static final String incorrectArgsMsg = "Incorrect arguments format";

    /**
     * Command constructor
     * 
     * @param name     name of the command
     * @param shortcut shortcut of the command, typically its firs letter
     * @param details  short description of the command
     * @param help     full description with help of the command
     */
    public Command(String name, String shortcut, String details, String help) {
        this.name = name;
        this.shortcut = shortcut;
        this.details = details;
        this.help = help;
    }

    /**
     * Executions of the command
     * 
     * @param game game where the command it's executed
     * @return true if the display has to refresh, false if not
     */
    public abstract boolean execute(Game game);

    /**
     * Parser for the command
     * 
     * @param commandWords parameters of the command
     * @return true if the parse was successful, false if not
     */
    public abstract Command parse(String[] commandWords);

    /**
     * Checks if the name given matches with the name of the command
     * 
     * @param name name given
     * @return true if they match, false if not
     */
    protected boolean matchCommandName(String name) {
        return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
    }

    /**
     * Parser for commands with no extra parameters
     * 
     * @param words parameters given for the command
     * @return true if the parse was successful, false if not
     */
    protected Command parseNoParamsCommand(String[] words) {
        if (matchCommandName(words[0])) {
            if (words.length != 1) {
                System.err.println(incorrectArgsMsg);
                return null;
            }
            return this;
        }
        return null;
    }

    /**
     * 
     * @return help string of the command
     */
    public String helpText() {
        return details + ":" + help + "\n";
    }
}
