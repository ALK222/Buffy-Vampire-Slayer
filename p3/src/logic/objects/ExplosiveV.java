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
    public boolean receiveLightAttack() {
        _hp = 0;
        return true;
    }

    public boolean receiveGarlicPush() {
        if (_game.isIn(_x - 1, _y) == -1) {
            _x++;
            _cycle = 1;
            if (!_game.isOnBoard(_x, _y, true)) {
                _hp = 0;
                onDead();
            }
            return true;
        }
        return false;
    }

    @Override
    public void onDead() {
        _game.explosiveDamage(_x, _y);
        Vampire.decOnBoard(1);
    }

}
