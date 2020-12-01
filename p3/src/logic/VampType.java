package logic;

public enum VampType {

    NORMAL("N"), DRACULA("D"), EXPLOSIVE("E");

    private String _name;

    VampType(String name) {
        this._name = name;
    }

    public String getName() {
        return _name;
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
