package logic.objects;

import logic.Game;
import logic.interfaces.IAttack;

/**
 * Slayer of Vampires. Rip and tear
 */
public class Slayer extends GameObject {

    // ATTRIBUTES

    private static final int _COST = 50;
    private static final int _DAMAGE = 1;

    // CONSTRUCTOR

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

    // GETTERS

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

    // METHODS

    @Override
    public boolean haveLanded() {
        return false;
    }

    @Override
    public boolean receiveVampireAttack(int damage) {
        _hp -= damage;
        return true;
    }

    @Override
    public boolean receiveDraculaAttack() {
        _hp = 0;
        return true;
    }

    @Override
    public String toString() {
        return "S[" + _hp + "]";
    }

    @Override
    public String stringify() {
        return String.format("S;%;%;%", _x, _y, _hp);
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
        int i = _x;
        while (!found && i < _game.getX()) {
            IAttack aux = _game.getAttackableIn(i, _y);
            if (aux != null) {
                found = aux.receiveSlayerAttack(_DAMAGE);
            }
            ++i;
        }

    }

}
