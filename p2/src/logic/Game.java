package logic;

import java.util.Random;

import logic.interfaces.IAttack;
import logic.interfaces.IPrintable;
import logic.objects.GameObjectBoard;
import logic.objects.Player;
import logic.objects.Slayer;
import logic.objects.Vampire;

/**
 * Main logic of the game
 */
public class Game implements IPrintable {

    // Attributes
    private int _dimX;
    private int _dimY;
    private static final int _VAMPIREHEALTH = 5;
    private static final int _SLAYERHEALTH = 3;
    private static final int _STARTERCOINS = 50;
    private int _cycle;
    private long _seed;
    private Level _lvl;
    private Player _pl;
    private Random _rand;
    private boolean _exit;

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
        _board = new GameObjectBoard(_dimX, _dimY);
        _finalMsg = "Nobody wins...";
        _exit = false;
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
     * Sets the exit flag to true
     */
    public void exit() {
        _exit = true;
    }

    /**
     * All the things that happen from one cycle to another
     */
    public void update() {
        _pl.chanceCoins();

        _board.computerAction();

        if (_rand.nextDouble() < _lvl.getFreq() && Vampire.getNumVamp() > 0) {
            int x = _dimX - 1;
            int y = _rand.nextInt(_dimY);
            while (_board.isIn(x, y) != -1) {
                y = _rand.nextInt(_dimY);
            }
            Vampire aux = new Vampire(this, x, y, _VAMPIREHEALTH);
            Vampire.addOnBoard(1);
            Vampire.decreaseRem(1);
            _board.add(aux);
        }
        _cycle++;
    }

    /**
     * Prints all the info of the game: cycles passed, coins, vampires remaining to
     * appear and vampires on the board
     */
    @Override
    public String getInfo() {
        String aux = cycleNum + _cycle + "\n"; // Display for the number of the current game cycle
        aux += coinStr + _pl.getCoins() + "\n"; // Display of the current coin counter
        aux += vampStr + Vampire.getNumVamp() + "\n"; // Display of the number of vampires remaining to spawn
        aux += vampOnBoardStr + Vampire.getOnBoard() + "\n"; // Display of the number of vampires on the board
        return aux;
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
            _finalMsg = "Vampires win!";
            return true;
        }
        if (_exit) {
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
        if (!_board.isComplete()) {
            System.out.println("Cant put any more slayers");
            return false;
        }
        if (_pl.getCoins() >= Slayer.getCost()) {
            if (_board.isIn(i, j) != -1) {
                System.out.println("Slayer or vampire already in that coordinate, choose other");
                return false;
            } else {
                if (0 > i || i >= (_dimX - 1) || 0 > j || j > (_dimY - 1)) {
                    System.out.println("Invalid position, try again");
                    return false;
                }
                _board.add(new Slayer(this, i, j, _SLAYERHEALTH));
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
    @Override
    public String getPositionToString(int i, int j) {
        return _board.toString(j, i);
    }

    /**
     * Resets the game
     */
    public void reset() {
        _board.reset();
        _cycle = 0;
        _pl.setCoins(_STARTERCOINS);
        Vampire.setNumVamp(_lvl.getNumVamp());
        Vampire.setOnBoard(0);
    }

    /**
     * Removes dead objects from the game
     */
    public void removeDead() {
        _board.removeDead();
    }

    /**
     * Returns if an object is in the position given
     * 
     * @param i x coordiinate
     * @param j y coordinate
     * @return the index in the arraylist of the object or -1 if no object was found
     */
    public int isIn(int i, int j) {
        return _board.isIn(i, j);
    }

    /**
     * Returns a copy of an object to be attacked
     * 
     * @param x x coordinate
     * @param y y coordinate
     * @return the object at the given coordinates
     */
    public IAttack getAttackableIn(int x, int y) {
        return _board.objectAt(x, y);
    }
}
