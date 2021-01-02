package logic.objects;

import logic.Game;
import logic.interfaces.IAttack;

/**
 * Vampires, enemies of the game
 */
public class Vampire extends GameObject {

    // ATTRIBUTES

    private static int _DAMAGE = 1; // Damage per attack
    private static int _ONBOARD; // Number of vampires on board
    private static int numVamp; // Number of vampires to spawn
    protected int _cycle;
    private static String _NOREMAININGMSG = "No more remaining vampires left";

    // CONSTRUCTOR
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
        _cycle = 1;
    }

    // GETTERS

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

    public static String getNoRemainingMSG() {
        return _NOREMAININGMSG;
    }

    // SETTERS

    /**
     * Sets the number of vampires on the board
     * 
     * @param i sets the current number of vampires in the board
     */
    public static void setOnBoard(int i) {
        _ONBOARD = i;
    }

    /**
     * Sets the number of vampires to appear
     * 
     * @param nv set the number of vampires to appear
     */
    public static void setNumVamp(int nv) {
        numVamp = nv;
    }

    // METHODS

    @Override
    public boolean haveLanded() {
        return _x < 0;
    }

    @Override
    public boolean receiveExplosiveAttack() {
        _hp--;
        return true;
    }

    @Override
    public boolean receiveGarlicPush() {
        _x++;
        if (!_game.isOnBoard(_x, _y, true)) {
            _hp = 0;
            onDead();
        }
        return true;
    }

    @Override
    public boolean receiveLightAttack() {
        _hp = 0;
        onDead();
        return true;
    }

    /**
     * 
     * @param d damage taken by a vampire
     */
    @Override
    public boolean receiveSlayerAttack(int damage) {
        if (_hp > 0) {
            _hp -= damage;
            if (_hp <= 0) {
                onDead();
            }
            return true;
        }
        return false;
    }

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
            if (_cycle % 2 == 0) {
                _x -= 1;
            }
            _cycle++;
        }
    }

    public void onDead() {
        Vampire.decOnBoard(1);
    }

    /**
     * checks if it can attack a slayer
     */
    @Override
    public void attack() {
        IAttack aux = _game.getAttackableIn(_x - 1, _y);
        if (aux != null) {
            aux.receiveVampireAttack(_DAMAGE);
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

}
