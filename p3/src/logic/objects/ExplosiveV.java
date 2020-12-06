package logic.objects;

import logic.Game;

/**
 * <p>
 * Explosive vampires, kind of support.
 * 
 * <p>
 * When they die, all surrounding vampires get a bonus in damage
 */
public class ExplosiveV extends Vampire {

    /**
     * Explosive Vampire Constructor
     * 
     * @param game instance of the game
     * @param x    x coordinate of spawn
     * @param y    y coordinate of spawn
     * @param hp   initial health
     */
    public ExplosiveV(Game game, int x, int y, int hp) {
        super(game, x, y, hp);
    }

    @Override
    public String toString() {
        return "EV[" + _hp + "]";
    }

    @Override
    public void onDead() {
        _game.explosiveDamage(_x, _y);
        Vampire.decOnBoard(1);
    }

    @Override
    public boolean receiveLightAttack() {
        _hp = 0;
        return true;
    }

}
