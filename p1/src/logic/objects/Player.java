package logic.objects;

/**
 * 
 * The hand that controlls everything
 * 
 */
public class Player {

    private int _coins;

    /**
     * 
     * @param game  instance of the game
     * @param coins starting coins of the player
     */
    public Player(int coins) {
        _coins = coins;
    }

    // Getters
    /**
     * 
     * @return the number of coins that the player has
     */
    public int getCoins() {
        return _coins;
    }

    // Setters
    /**
     * Set the number of coins to i
     * 
     * @param i number of coins to be set
     */
    public void setCoins(int i) {
        _coins = i;
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
