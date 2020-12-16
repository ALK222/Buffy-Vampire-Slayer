package logic;

/**
 * Enum to decide the type of vampire to spawn
 */
public enum VampType {

    // ENUM CONSTRUCTORS
    NORMAL("N"), DRACULA("D"), EXPLOSIVE("E");

    // ATTRIBUTES
    private String _name;
    private static final String CLASSNOTFOUND = "Vampire class not found";

    // CONSTRUCTOR

    /**
     * VampType constructor
     * 
     * @param name name of the vampire type
     */
    VampType(String name) {
        this._name = name;
    }

    /**
     * Resturns the name of the vampType
     * 
     * @return the symbol of the vampire type
     */
    public String getName() {
        return _name;
    }

    /**
     * 
     * @return an error message when the class of vampire is not found
     */
    public static String getNotFoundMsg() {
        return CLASSNOTFOUND;
    }

    public String toString() {
        return _name;
    }

    // Methods
    /**
     * Parse a string into a vampType
     * 
     * @param inputString string to parse
     * @return null if string is not recognized, a level if match
     */
    public static VampType parse(String inputString) {
        for (VampType vt : VampType.values())
            if (vt.name().equalsIgnoreCase(inputString))
                return vt;
        return null;
    }

    public static String all(String separator) {
        String allTypes = "";
        for (VampType vt : VampType.values())
            allTypes += vt.name() + separator;
        return allTypes.substring(0, allTypes.length() - separator.length());
    }
}
