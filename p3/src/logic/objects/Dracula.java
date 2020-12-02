package logic.objects;

import logic.Game;
import logic.interfaces.IAttack;

/**
 * <p>
 * The one and only Dracula
 * 
 * <p>
 * Only one Dracula can exist at a time. Dracula can kill any slayer on one hit
 */
public class Dracula extends Vampire {

    // ATTRIBUTES

    private static boolean onBoard = false;

    // CONSTRUCTOR
    /**
     * Dracula object constructor
     * 
     * @param game instance of the game
     * @param x    x coordinate of spawn
     * @param y    y coordinate of spawn
     * @param hp   initial health
     */
    public Dracula(Game game, int x, int y, int hp) {
        super(game, x, y, hp);
    }

    // GETTERS
    /**
     * Checks if Dracula is present
     * 
     * @return true if is on board, false if not
     */
    public static boolean isOnBoard() {
        return onBoard;
    }

    // SETTERS
    /**
     * Changes the state of Dracula on board
     * 
     * @param o new state, true if is on board, false if not
     */
    public static void setOnBoard(boolean o) {
        onBoard = o;
    }

    // METHODS

    @Override
    public boolean receiveLightAttack() {
        return false;
    }

    @Override
    public String toString() {
        return "D[" + _hp + "]";
    }

    @Override
    public void attack() {
        IAttack aux = _game.getAttackableIn(_x - 1, _y);
        if (aux != null) {
            aux.receiveDraculaAttack();
        }
    }

    @Override
    public void onDead() {
        onBoard = false;
        Vampire.decOnBoard(1);
    }

}
