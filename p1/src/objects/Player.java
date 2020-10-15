package Objects;

import Logic.Game;

public class Player {

    /**
     * 
     * The hand that controlls everything
     * 
     */
    private int _coins;
    private Game _game;

    public Player(Game game, int coins) {
        _coins = coins;
        _game = game;
    }

    // Getters

    public int getCoins() {
        return _coins;
    }

    // Methods

    public void addCoins(int i) {
        _coins += i;
    }

    public void decCoins(int cost) {
        _coins -= cost;
    }

}
