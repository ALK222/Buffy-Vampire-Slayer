package logic.objects;

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
    private static int _DAMAGE = 1;

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

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    // Methods
    public String toString() {
        return "S[" + _hp + "]";
    }

    public void attack() {
        boolean found = false;
        int i = 0;
        while (!found && i < _game.getX()) {
            int n = _game.vampIn(i, _y);
            if (n != 1) {
                found = true;
                _game.attackVamp(n, _DAMAGE);
            }
        }
    }

}
