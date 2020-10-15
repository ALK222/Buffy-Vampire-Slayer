package objects;

import logic.Game;

public class Slayer {

    /**
     * 
     * Natural enemy of vampires
     * 
     */

    // Attributes
    private static int _COST = 50;
    private Game _game;
    private int _hp;
    private int _x;
    private int _y;

    // Constructor
    public Slayer(Game game, int x, int y) {
        _hp = 3;
        _x = x;
        _y = y;
    }

    // Getters

    public static int getCost() {
        return _COST;
    }

    // Methods
    public String toString() {
        return "S[" + _hp + "]";
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }
}