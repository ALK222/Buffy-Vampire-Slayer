package logic.objects;

import logic.Game;

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

    @Override
    public String toString() {
        return "S[" + _hp + "]";
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
            int n = _game.vampIn(i, _y);
            if (n != -1) {
                found = true;
                _game.attackVamp(n, _DAMAGE);
            }
            i++;
        }

    }

    @Override
    public void damage(int d) {
        _hp -= d;
    }

}
