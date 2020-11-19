package logic.objects;

import logic.Game;
import logic.interfaces.IAttack;

/**
 * Abstract class from where all de game objects extend
 */
public abstract class GameObject implements IAttack {

    // Attributes

    protected int _hp;
    protected int _x;
    protected int _y;

    protected Game _game;

    /**
     * Constructor for the GameObject class
     * 
     * @param game instance of game
     * @param x    x coordinate
     * @param y    y coordinate
     * @param hp   health points of the object
     */
    public GameObject(Game game, int x, int y, int hp) {
        _game = game;
        _x = x;
        _y = y;
        _hp = hp;
    }

    // Getters

    /**
     * 
     * @return x coordinate of a GameObject
     */
    public int getX() {
        return _x;
    }

    /**
     * 
     * @return y coordinate of a GameObject
     */
    public int getY() {
        return _y;
    }

    /**
     * 
     * @return the hp of the object
     */
    public int getHp() {
        return _hp;
    }

    /**
     * 
     * @return true if it's avampire, false if not
     */
    public abstract boolean isVampire();

    /**
     * 
     * @return the damage points of the object
     */
    public abstract int getDamage();

    // Methods

    /**
     * Symbol and HP of a GameObject
     */
    public abstract String toString();

    /**
     * Attack process of a GameObject
     */
    public abstract void attack();

    /**
     * Computer actions for a GameObject: attack, movement etc
     */
    public abstract void computerAction();

    /**
     * 
     * @return true if a vampire has landed, false if not or if the object is a
     *         slayer
     */
    public abstract boolean haveLanded();
}
