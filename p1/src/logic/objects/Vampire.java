package logic.objects;

import logic.Game;

/**
 * Enemy of the slayer, your enemmy too
 */
public class Vampire {

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
    private Game _game;

    // Constructor

    /**
     * 
     * @param hp   hit points of the vampire
     * @param x    starting x coordinate
     * @param y    y coordinate
     * @param game instance of the main game
     */
    public Vampire(int hp, int x, int y, Game game) {
        _hp = hp;
        _x = x;
        _y = y;
        _cycle = 0;
        _game = game;
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

    /**
     * 
     * @return the current x coordinate of the vampire
     */
    public int getX() {
        return _x;
    }

    /**
     * 
     * @return the current y coordinate of the vampire
     */
    public int getY() {
        return _y;
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

    /**
     * @return V[hp]
     */
    public String toString() {
        return "V[" + _hp + "]";
    }

    /**
     * 
     * @return true if the vampire is on the final column, false if not
     */
    public boolean hasArrived() {
        return _x <= 0;
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
     * @param i number of vampires that have been aded to the board
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

    /**
     * Movement of the vampires, if a slayer is in front of them they do not move
     */
    public void movement() {
        if (_game.slayerIn(_x - 1, _y) == -1) {
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
    }

    /**
     * checks if it can attack a slayer
     */
    public void attack() {
        int n = _game.slayerIn(_x - 1, _y);
        if (n != -1) {
            _game.attackSlayer(n, _DAMAGE);
        }
    }

}
