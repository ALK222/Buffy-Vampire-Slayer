package logic;

/**
 * Level based numbers
 */
public enum Level {

    // Enum definitions
    EASY("easy", 3, 0.1, 8, 4), HARD("hard", 5, 0.2, 7, 3), INSANE("insane", 10, 0.3, 5, 6);

    // Attributes
    @SuppressWarnings("unused")
    private String _name; // Name of the mode
    private int _numVampiros; // Ammount of vampires per game
    private double _freq; // Frequency of vampire spawn
    private int _x; // X size for board
    private int _y; // Y size for board

    // Constructor
    /**
     * 
     * @param name    name of the mode
     * @param numVamp number of vampires to appear
     * @param freq    frequency of vampire spawn
     * @param x       number of columns
     * @param y       number of rows
     */
    Level(String name, int numVamp, double freq, int x, int y) {
        _name = name;
        _numVampiros = numVamp;
        _freq = freq;
        _x = x;
        _y = y;
    }

    // Getters

    public int getNumVamp() {
        return _numVampiros;
    }

    public double getFreq() {
        return _freq;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    // Methods
    /**
     * Parse a string into a level
     * 
     * @param inputString string to parse
     * @return null if string is not recognized, a level if match
     */
    public static Level parse(String inputString) {
        for (Level level : Level.values())
            if (level.name().equalsIgnoreCase(inputString))
                return level;
        return null;
    }

    public static String all(String separator) {
        String allLevels = "";
        for (Level level : Level.values())
            allLevels += level.name() + separator;
        return allLevels.substring(0, allLevels.length() - separator.length());
    }
}
