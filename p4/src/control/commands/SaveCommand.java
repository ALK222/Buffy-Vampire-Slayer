package control.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import control.exceptions.CommandExecuteException;
import control.exceptions.CommandParseException;
import logic.Game;
import view.GamePrinter;
import view.Stringifier;

public class SaveCommand extends Command {

    private static final String _name = "Save";
    private static final String _shortcut = "S";
    private static final String _details = "[S]ave <filename>";
    private static final String _help = "Saves the game in its current state to a file with <filename>.dat.";

    private String _file;

    private static final String FILEEXTENSION = ".dat";
    // private static final String REWRITEMSG = " already exists, do you want to
    // rewrite? (Y/N/cancel)";
    private static final String SAVEDMSG = "Game successfully saved in file ";

    /**
     * AddCommand constructor without arguments for CommandGenerator
     */
    public SaveCommand() {
        super(_name, _shortcut, _details, _help);
    }

    /**
     * AddCommand constructor with coordinates
     * 
     * @param f file name
     */
    public SaveCommand(String f) {
        super(_name, _shortcut, _details, _help);
        _file = f;
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            save(_file, game);
        } catch (Exception e) {
            System.out.println(e);
            throw new CommandExecuteException("[ERROR]: failed to save the game", e);
        }
        return false;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if (!matchCommandName(commandWords[0])) {
            return null;
        } else if (commandWords.length != 2) {
            throw new CommandParseException("[ERROR]: Command " + _name + " : " + incorrectNumberOfArgsMsg);
        }
        return new SaveCommand(commandWords[1]);
    }

    /**
     * Saves the state of the game into a file
     * 
     * @param file name of the file
     * @throws IOException if the named file exists but is a directory rather than a
     *                     regular file, does not exist but cannot be created, or
     *                     cannot be opened for any other reason
     */
    public void save(String file, Game g) throws IOException {
        GamePrinter saver = new Stringifier(g);
        String state = saver.toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file + FILEEXTENSION, false))) {
            writer.append(state);
            writer.close();
            System.out.println(SAVEDMSG + file + FILEEXTENSION);
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * <p>
     * Unused function that implements a true save.
     * </p>
     * <p>
     * Implements a warning message if the file already exists to rewrite.
     * </p>
     * <p>
     * If the user selects not to rewrite the file, the funcition will create other
     * file adding a number with the new info.
     * </p>
     * 
     * @param file Name of the file to save
     * @throws IOException             if the named file exists but is a directory
     *                                 rather than a regular file, does not exist
     *                                 but cannot be created, or cannot be opened
     *                                 for any other reason
     * @throws CommandExecuteException if the user picks an invalid option when
     *                                 selecting if the file is going to be
     *                                 rewritten or not or if the operation is
     *                                 canceled
     */
    public void functionalSave(String file) throws IOException, CommandExecuteException {
        // File f = new File(file + FILEEXTENSION);
        // GamePrinter saver = new Stringifier(this);
        // saver.setGame(this);
        // String saveState = saver.toString();
        // if (f.exists()) {
        // System.out.println("File " + file + FILEEXTENSION + REWRITEMSG);
        // Scanner in = new Scanner(System.in);
        // String rewrite = in.nextLine();
        // in.close();
        // switch (rewrite.toLowerCase()) {
        // case "y":
        // case "yes":
        // PrintWriter writer1 = new PrintWriter(file + FILEEXTENSION);
        // writer1.print("");
        // writer1.close();
        // break;
        // case "n":
        // case "no":
        // int i = 1;
        // while (f.exists()) {
        // f = new File(file + i + FILEEXTENSION);
        // }
        // file += i;
        // case "cancel":
        // throw new CommandExecuteException("[ERROR]: Operation canceled");
        // default:
        // throw new CommandExecuteException("[ERROR]: input not recogniced");
        // }
        // }
        // PrintWriter writer = new PrintWriter(file + FILEEXTENSION);
        // writer.append(saveState);
        // writer.close();
        // System.out.println(SAVEDMSG + file + FILEEXTENSION);
    }
}
