package logic.objects;

import logic.Game;

/**
 * 
 * The hand that controlls everything
 * 
 */
public class Player {

    private int _coins;
    private Game _game;

    /**
     * 
     * @param game  instance of the game
     * @param coins starting coins of the player
     */
    public Player(Game game, int coins) {
        _coins = coins;
        _game = game;
    }

    // Getters
    /**
     * 
     * @return the number of coins that the player has
     */
    public int getCoins() {
        return _coins;
    }

    // Methods

    /**
     * 
     * @param i number of coins added to the player
     */
    public void addCoins(int i) {
        _coins += i;
    }

    /**
     * 
     * @param cost number of coins subtracted from the player
     */
    public void decCoins(int cost) {
        _coins -= cost;
    }

}
