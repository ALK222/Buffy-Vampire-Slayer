package logic.objects;

import logic.Game;
import logic.interfaces.IAttack;

/**
 * The one and only Dracula
 */
public class Dracula extends Vampire {

    private static boolean onBoard = false;

    public Dracula(Game game, int x, int y, int hp) {
        super(game, x, y, hp);
    }

    public static boolean isOnBoard() {
        return onBoard;
    }

    public static void setOnBoard(boolean o) {
        onBoard = o;
    }

    @Override
    public void attack() {
        IAttack aux = _game.getAttackableIn(_x - 1, _y);
        if (aux != null) {
            aux.receiveDraculaAttack();
        }
    }

    @Override
    public boolean receiveLightAttack() {
        return false;
    }

    @Override
    public String toString() {
        return "D[" + _hp + "]";
    }

    @Override
    public void onDead() {
        onBoard = false;
        Vampire.decOnBoard(1);
    }

}
