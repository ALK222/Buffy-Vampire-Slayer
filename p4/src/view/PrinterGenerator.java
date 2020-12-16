package view;

public class PrinterGenerator {

    private static GamePrinter[] availablePrinters = { new BoardPrinter(), new Stringifier(),

    };

    public static GamePrinter parse(String name) {
        GamePrinter printer = null;
        for (GamePrinter p : availablePrinters) {
            printer = p.parse(name);
            if (printer != null)
                break;
        }
        return printer;
    }

    public static String printerHelp() {
        StringBuilder printers = new StringBuilder();
        for (GamePrinter p : availablePrinters)
            printers.append(p.helpText());
        return printers.toString();
    }

}
