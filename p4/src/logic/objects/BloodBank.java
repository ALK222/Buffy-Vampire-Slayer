package logic.objects;

import logic.Game;

/**
 * <p>
 * BloodBank, kind of useless object
 * 
 * <p>
 * Gives coins to the player based on how much has been paid for the bank
 */
public class BloodBank extends GameObject {

    // ATTRIBUTES
    private int _cost;
    private static final double _CUANTITY = 0.1; // Cuantity of the total coins received

    public BloodBank(Game game, int x, int y, int hp, int cost) {
        super(game, x, y, hp);
        _cost = cost;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public boolean haveLanded() {
        return false;
    }

    @Override
    public String toString() {
        return "B[" + _cost + "]";
    }

    @Override
    public String stringify() {
        return String.format("B;%d;%d;%d;%d", _x, _y, _hp, _cost);
    }

    @Override
    public void attack() {
        // Peaceful boi

    }

    @Override
    public void computerAction() {
        _game.addCoins((int) (_cost * _CUANTITY));
    }

    @Override
    public boolean receiveVampireAttack(int damage) {
        _hp = 0;
        return true;
    }

    @Override
    public boolean receiveDraculaAttack() {
        _hp = 0;
        return true;
    }

}
