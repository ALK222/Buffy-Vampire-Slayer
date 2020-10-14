package Logic;

public enum Level {

    /*
     *
     * Level based numers
     *
     */

    // Enum definitions
    EASY(3, 0.1, 8, 4), HARD(5, 0.2, 7, 3), INSANE(10, 0.3, 5, 6);

    // Attributes
    private int _numVampiros; // Ammount of vampires per game
    private double _freq; // Frequency of vampire spawn
    private int _x; // X size for board
    private int _y; // Y size for board

    // Constructor
    Level(int numVamp, double freq, int x, int y) {
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
    public static Level parse(String l) {
        switch (l) {
            case "EASY":
                return EASY;
            case "HARD":
                return HARD;
            case "INSANE":
                return INSANE;
        }
        return Level.EASY;
    }
}
