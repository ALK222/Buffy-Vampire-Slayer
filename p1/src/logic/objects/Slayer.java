package logic.objects;

import logic.Game;

/**
 * Enemy of the vampires, the player puts them to work
 */
public class Slayer {

    // Attributes
    private static int _COST = 50;
    private Game _game;
    private int _hp;
    private int _x;
    private int _y;
    private static int _DAMAGE = 1;

    // Constructor
    /**
     * Constructor of the Slayer
     * 
     * @param game instance of the main game
     * @param x    x coordinate
     * @param y    y coordinate
     */
    public Slayer(Game game, int x, int y) {
        _hp = 3;
        _x = x;
        _y = y;
        _game = game;
    }

    // Getters
    /**
     * 
     * @return the cost of one slayer
     */
    public static int getCost() {
        return _COST;
    }

    /**
     * 
     * @return the x coordinate of the slayer
     */
    public int getX() {
        return _x;
    }

    /**
     * 
     * @return the y coordinate of the slayer
     */
    public int getY() {
        return _y;
    }

    // Methods

    /**
     * @return S[hp]
     */
    public String toString() {
        return "S[" + _hp + "]";
    }

    /**
     * Looks for the first vampire in the row and shoots, only hits once (I suppose
     * that piercing bullets are expensive)
     */
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

    /**
     * 
     * @param d damage taken by a slayer
     */
    public void damage(int d) {
        _hp -= d;
    }

}
