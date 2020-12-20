package view;

import logic.Game;

public enum PrinterType {

    BOARDPRINTER("boardprinter", "prints the game formatted as a board of dimension: ", new BoardPrinter()),
    STRINGIFIER("stringifier", "prints the game as plain text", new Stringifier());

    private String printerName;
    private String helpText;
    private GamePrinter printerObject;

    private PrinterType(String name, String text, GamePrinter printer) {
        printerName = name;
        helpText = text;
        printerObject = printer;
    }

    public static String printerHelp(Game game) {
        String helpString = "";
        for (PrinterType printer : PrinterType.values())
            helpString += String.format("%s : %s%s%n", printer.printerName, printer.helpText,
                    (printer == BOARDPRINTER ? game.getX() + " x " + game.getY() : ""));
        return helpString;
    }

    // Assumes a max of one object of each printer type is needed (otherwise return
    // copy)
    public void setGame(Game game) {
        printerObject.setGame(game);
    }

    public String printGame() {
        return printerObject.toString();
    }

}
