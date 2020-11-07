package logic.objects;

import logic.Game;

/**
 * Slayer of Vampires. Reap and tear
 */
public class Slayer extends GameObject {

    // Attributes
    private static final int _COST = 50;
    private static final int _DAMAGE = 1;

    /**
     * Constructor of the Slayer
     * 
     * @param game instance of game
     * @param x    x coordinate
     * @param y    y coordinate
     * @param hp   Health points
     */
    public Slayer(Game game, int x, int y, int hp) {
        super(game, x, y, hp);
    }

    // Getters

    /**
     * 
     * @return the cost of a slayer
     */
    public static int getCost() {
        return _COST;
    }

    public boolean isVampire() {
        return false;
    }

    public int getDamage() {
        return _DAMAGE;
    }

    // Methods

    @Override
    public String toString() {
        return "S[" + _hp + "]";
    }

    @Override
    public void computerAction() {
        this.attack();
    }

    @Override
    /**
     * Looks for the first vampire in the row and shoots, only hits once (I suppose
     * that piercing bullets are expensive)
     */
    public void attack() {
        boolean found = false;
        int i = 0;
        while (!found && i < _game.getX()) {
            int n = _game.isIn(i, _y);
            if (n != -1) {
                if (_game.attack(this, n)) {
                    found = true;
                }
            }
            i++;
        }

    }

    @Override
    public void damage(int d) {
        _hp -= d;
    }

    @Override
    public boolean haveLanded() {
        return false;
    }
}
