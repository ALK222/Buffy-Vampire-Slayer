package logic.objects;

import java.util.Random;

/**
 * <p>
 * The hand that controls everything
 * 
 * <p>
 * Manager of coins, not much else
 */
public class Player {

    // ATTRIBUTES

    private int _coins;
    private Random _rand;
    private static final double _FREQCOIN = 0.50;
    private static final int _COINS_RECEIVED = 10;

    // CONSTRUCTOR
    /**
     * 
     * @param game  instance of the game
     * @param coins starting coins of the player
     */
    public Player(int coins, Random rand) {
        _rand = rand;
        _coins = coins;
    }

    // GETTERS
    /**
     * 
     * @return the number of coins that the player has
     */
    public int getCoins() {
        return _coins;
    }

    // SETTERS
    /**
     * Set the number of coins to i
     * 
     * @param i number of coins to be set
     */
    public void setCoins(int i) {
        _coins = i;
    }

    // METHODS

    /**
     * Adds coins to the player
     * 
     * @param d number of coins added to the player
     */
    public void addCoins(int d) {
        _coins += d;
    }

    /**
     * Removes coins from the player
     * 
     * @param cost number of coins subtracted from the player
     */
    public void decCoins(int cost) {
        _coins -= cost;
    }

    /**
     * Calculates if player should receive coins
     */
    public void chanceCoins() {
        if (_rand.nextFloat() > _FREQCOIN) {
            this.addCoins(_COINS_RECEIVED);
        }
    }

}
