package logic;

import java.util.Random;

import logic.objects.Player;
import logic.objects.Slayer;
import logic.objects.Vampire;

/**
 * Main logic of the game
 */
public class Game {

    // Attributes
    private int _dimX;
    private int _dimY;
    private static final int _VAMPIREHEALTH = 5;
    private static final int _STARTERCOINS = 50;
    private int _cycle;
    private long _seed;
    private Level _lvl;
    private Player _pl;
    private Random _rand;

    private GameObjectBoard _board;
    private String _finalMsg;

    // String tags
    private static String cycleNum = "Number of cycles: ";
    private static String coinStr = "Coins ";
    private static String vampStr = "Remaining vampires: ";
    private static String vampOnBoardStr = "Vampires on the board: ";

    // Constructor
    /**
     * 
     * @param seed seed for random calculations
     * @param l    mode of difficulty
     */
    public Game(Long seed, Level l) {
        _cycle = 0;
        _lvl = l;
        _seed = seed;
        _dimX = _lvl.getX();
        _dimY = _lvl.getY();
        _rand = new Random(_seed);
        _pl = new Player(_STARTERCOINS, _rand); // If 0 coins are given at start, it is very hard to win
        Vampire.setNumVamp(_lvl.getNumVamp());
        _board = new GameObjectBoard(this);
        _finalMsg = "Game Over!";
    }

    // Getters
    /**
     * 
     * @return number of columns
     */
    public int getX() {
        return _dimX;
    }

    /**
     * 
     * @return number of rows
     */
    public int getY() {
        return _dimY;
    }

    /**
     * 
     * @return message displayed when the game has ended
     */
    public String getFinalMsg() {
        return _finalMsg;
    }

    // Methods
    /**
     * All the things that happen from one cycle to another
     */
    public void update() {
        _pl.chanceCoins();

        _board.vampMovement();

        _board.slayerAttacks();

        _board.vampAttacks();

        if (_rand.nextDouble() <= _lvl.getFreq() && Vampire.getNumVamp() > 0) {
            int x = _dimX - 1;
            int y = _rand.nextInt(_dimY - 1);
            while (_board.vampIn(x, y) != -1) {
                y = _rand.nextInt(_dimY - 1);
            }
            Vampire aux = new Vampire(_VAMPIREHEALTH, x, y, this);
            _board.add(aux);
        }
        removeDead();
        _cycle++;
    }

    /**
     * Prints all the info of the game: cycles passed, coins, vampires remaining to
     * appear and vampires on the board
     */
    public void printInfo() {
        System.out.println(cycleNum + _cycle); // Display for the number of the current game cycle
        System.out.println(coinStr + _pl.getCoins()); // Display of the current coin counter
        System.out.println(vampStr + Vampire.getNumVamp()); // Display of the number of vampires remaining to spawn
        System.out.println(vampOnBoardStr + Vampire.getOnBoard()); // Display of the number of vampires on the board
    }

    /**
     * Checks all the possible endings of the game
     * 
     * @return true if the game has ended, false if not
     */
    public boolean checkEnd() {
        if (Vampire.getNumVamp() == 0 && Vampire.getOnBoard() == 0) {
            _finalMsg = "You win!";
            return true;
        }
        if (_board.haveLanded()) {
            _finalMsg = "Game over!";
            return true;
        }
        return false;
    }

    /**
     * Command execution to add a slayer to the board
     * 
     * @param i x coordinate
     * @param j y coordinate
     * 
     * @return true if slayer can be added, false if not
     */
    public boolean addSlayer(int i, int j) {
        if (_board.slayerComplete()) {
            System.out.println("Cant put any more slayers");
            return false;
        }
        if (_pl.getCoins() >= Slayer.getCost()) {
            if (_board.slayerIn(i, j) != -1 || _board.vampIn(i, j) != -1) {
                System.out.println("Slayer or vampire already in that coordinate, choose other");
                return false;
            } else {
                if (0 > i || i >= (_dimX - 1) || 0 > j || j > (_dimY - 1)) {
                    System.out.println("Invalid position, try again");
                    return false;
                }
                _board.add(new Slayer(this, i, j));
                _pl.decCoins(Slayer.getCost());
                return true;
            }
        } else {
            System.out.println("Not enough coins to hire a slayer");
            return false;
        }
    }

    /**
     * 
     * @return the number of vampires in this level
     */
    public int getNumVamps() {
        return _lvl.getNumVamp();
    }

    /**
     * Returns a string with the character at a given point
     * 
     * @param i x coordinate
     * @param j y coordinate
     * @return The string representation of a character or a black string if there
     *         is no character there
     */
    public String characterAtToString(int i, int j) {
        return _board.toString(i, j);
    }

    /**
     * Searches if a Slayer is in a given set of coordinates
     * 
     * @param i x coordinate
     * @param j y coordinate
     * @return the position of the slayer in that point or -1 if there is no slayer
     *         in that point
     */
    public int slayerIn(int i, int j) {
        return _board.slayerIn(i, j);
    }

    /**
     * Searches if a vampire is in a given set of coordinates
     * 
     * @param i x coordinate
     * @param j y coordinate
     * @return the position on the array of the vampire in that point or -1 if there
     *         is no vampire in that point
     */
    public int vampIn(int i, int j) {
        return _board.vampIn(i, j);
    }

    /**
     * Executes an attack on a vampire
     * 
     * @param n number of the vampire on the list
     * @param d damage that the vampire will take
     */
    public void attackVamp(int n, int d) {
        _board.attackVamp(n, d);
    }

    /**
     * Executes an attack on a slayer
     * 
     * @param n number of the slayer on the list
     * @param d damage that the slayer will take
     */
    public void attackSlayer(int n, int d) {
        _board.attackSlayer(n, d);
    }

    /**
     * Resets the game
     */
    public void reset() {
        _board.reset();
        _cycle = 0;
        _pl.setCoins(_STARTERCOINS);
        Vampire.setNumVamp(_lvl.getNumVamp());
    }

    /**
     * Removes dead objects from the game
     */
    public void removeDead() {
        _board.removeDead();
    }
}
