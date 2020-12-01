package logic.objects;

import logic.Game;

public class ExplosiveV extends Vampire {

    public ExplosiveV(Game game, int x, int y, int hp) {
        super(game, x, y, hp);
    }

    @Override
    public String toString() {
        return "EV[" + _hp + "]";
    }

    @Override
    public void onDead() {
        _game.increasePower(_x, _y);
        Vampire.decOnBoard(1);
    }

}
