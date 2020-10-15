package objects;

public class Vampire {
    /**
     * 
     * Natural enemy of Slayers
     * 
     */

    // Atributtes

    private static final int _DAMAGE = 1; // Damage per attack
    private static final int _SPEED = 1; // squares per movement
    private static final int _FREQ = 2; // frequence of movement
    private static int _ONBOARD; // Number of vampires on board
    private static int numVamp; // Number of vampires to spawn
    private int _hp;
    private int _x;
    private int _y;
    private int _cycle;

    // Constructor

    public Vampire(int hp, int x, int y) {
        _hp = hp;
        _x = x;
        _y = y;
        _cycle = 0;
    }

    // Getters

    public static int getNumVamp() {
        return numVamp;
    }

    public static int getOnBoard() {
        return _ONBOARD;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    // Setters

    public static void setOnBoard(int i) {
        _ONBOARD = i;
    }

    public static void setNumVamp(int nv) {
        numVamp = nv;
    }

    // Methods

    public String toString() {
        return "V[" + _hp + "]";
    }

    public boolean hasArrived() {
        return _x <= 0;
    }

    public static void decreaseRem(int i) {
        numVamp -= i;
    }

    public static void addOnBoard(int i) {
        _ONBOARD += i;
    }

    public static void decOnBoard(int i) {
        _ONBOARD -= i;
    }

    public void movement() {
        if (_cycle % 2 == 0 && _cycle != 0) {
            _x -= 1;
        }
        _cycle++;
    }

}
