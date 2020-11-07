package logic.objects;

import logic.Game;

/**
 * Vampires, enemies of the game
 */
public class Vampire extends GameObject {

    // Attributes
    private static final int _DAMAGE = 1; // Damage per attack
    private static int _ONBOARD; // Number of vampires on board
    private static int numVamp; // Number of vampires to spawn
    private int _cycle;

    /**
     * Constructor for the Vampire class
     * 
     * @param game instance of game
     * @param x    x coordinate
     * @param y    y coordinate
     * @param hp   Health points
     */
    public Vampire(Game game, int x, int y, int hp) {
        super(game, x, y, hp);
        _cycle = 0;
    }

    // Getters

    /**
     * 
     * @return the number of vampires remaining
     */
    public static int getNumVamp() {
        return numVamp;
    }

    /**
     * 
     * @return the number of vampires on board
     */
    public static int getOnBoard() {
        return _ONBOARD;
    }

    public boolean isVampire() {
        return true;
    }

    public int getDamage() {
        return _DAMAGE;
    }

    // Setters

    /**
     * 
     * @param i sets the current number of vampires in the board
     */
    public static void setOnBoard(int i) {
        _ONBOARD = i;
    }

    /**
     * 
     * @param nv set the number of vampires to appear
     */
    public static void setNumVamp(int nv) {
        numVamp = nv;
    }

    // Methods

    @Override
    public String toString() {
        return "V[" + _hp + "]";
    }

    @Override
    public void computerAction() {
        this.movement();
        this.attack();

    }

    /**
     * Movement of the vampires, if a slayer is in front of them they do not move
     */
    public void movement() {
        if (_game.isIn(_x - 1, _y) == -1) {
            if (_cycle % 2 == 0 && _cycle != 0) {
                _x -= 1;
            }
            _cycle++;
        }
    }

    /**
     * 
     * @param d damage taken by a vampire
     */
    public void damage(int d) {
        _hp -= d;
        if (_hp <= 0) {
            Vampire.decOnBoard(1);
        }
    }

    /**
     * checks if it can attack a slayer
     */
    public void attack() {
        int n = _game.isIn(_x - 1, _y);
        if (n != -1) {
            _game.attack(this, n);
        }
    }

    /**
     * 
     * @param i number of vampires to decrease the remaining vampires to appear
     */
    public static void decreaseRem(int i) {
        numVamp -= i;
    }

    /**
     * 
     * @param i number of vampires that have been added to the board
     */
    public static void addOnBoard(int i) {
        _ONBOARD += i;
    }

    /**
     * 
     * @param i number of vampires that have been removed from the board
     */
    public static void decOnBoard(int i) {
        _ONBOARD -= i;
    }

    public boolean haveLanded() {
        return _x < 0;
    }

}
