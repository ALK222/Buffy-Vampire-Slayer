package logic.objects;

import logic.Game;

/**
 * Abstract class from where all de game objects extend
 */
public abstract class GameObject {

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
     * @return the hp of the slayer
     */
    public int getHp() {
        return _hp;
    }

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
     * Damage taken by a GameObject
     * 
     * @param d value of the damage taken
     */
    public abstract void damage(int d);

    /**
     * Computer actions for a GameObject: attack, movement etc
     */
    public abstract void computerAction();
}
