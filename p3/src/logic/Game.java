package logic;

import java.util.Random;

import logic.interfaces.IAttack;
import logic.interfaces.IPrintable;
import logic.objects.Dracula;
import logic.objects.ExplosiveV;
import logic.objects.GameObject;
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

        // Normal Vampire spawn
        if (_rand.nextDouble() < _lvl.getFreq() && Vampire.getNumVamp() > 0) {
            int x = _dimX - 1;
            int y = _rand.nextInt(_dimY);
            while (!addVampire(x, y, VampType.NORMAL)) {
                y = _rand.nextInt(_dimY);
            }

        }

        // Dracula Spawn
        if (_rand.nextDouble() < _lvl.getFreq() && !Dracula.isOnBoard() && Vampire.getNumVamp() > 0) {
            int x = _dimX - 1;
            int y = _rand.nextInt(_dimY);
            while (!addVampire(x, y, VampType.DRACULA)) {
                y = _rand.nextInt(_dimY);
            }

        }

        // Explosive spawn
        if (_rand.nextDouble() < _lvl.getFreq() && Vampire.getNumVamp() > 0) {
            int x = _dimX - 1;
            int y = _rand.nextInt(_dimY);
            while (!addVampire(x, y, VampType.EXPLOSIVE)) {
                y = _rand.nextInt(_dimY);
            }

        }
        _cycle++;
    }

    public boolean addVampire(int x, int y, VampType type) {
        if (!isOnBoard(x, y, true)) {
            System.out.println("Invalid position, please try again");
            return false;
        }
        if (_board.isIn(x, y) != -1) {
            System.out.println("Cell occupied");
            return false;
        } else {
            GameObject aux = null;
            switch (type) {
                case DRACULA:
                    System.out.println("Dracula is alive");
                    aux = new Dracula(this, x, y, _VAMPIREHEALTH);
                    Dracula.setOnBoard(true);
                    break;
                case EXPLOSIVE:
                    aux = new ExplosiveV(this, x, y, _VAMPIREHEALTH);
                    break;
                case NORMAL:
                    aux = new Vampire(this, x, y, _VAMPIREHEALTH);
                    break;
                default:
                    System.out.println("Vampire class not found");
                    return false;
            }
            Vampire.addOnBoard(1);
            Vampire.decreaseRem(1);
            _board.add(aux);
            return true;
        }

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
        if (Vampire.getNumVamp() <= 0 && Vampire.getOnBoard() <= 0) {
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
                if (!isOnBoard(i, j, false)) {
                    System.out.println("Invalid position, try again");
                    return false;
                }
                _board.add(new Slayer(this, i, j, _SLAYERHEALTH));
                _pl.decCoins(Slayer.getCost());
                return true;
            }
        } else

        {
            System.out.println("Not enough coins to hire a slayer");
            return false;
        }
    }

    public boolean isOnBoard(int i, int j, boolean amplied) {
        int bondX = _dimX;
        int bondY = _dimY;
        if (!amplied) { // if used to check the boundaries for a vampire, the board is amplied
            bondX--;
            bondY--;
        }
        if (0 > i || i >= (bondX) || 0 > j || j > (bondY)) {
            return false;
        } else {
            return true;
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

    public void increasePower(int x, int y) {
        for (int i = x - 1; i < x + 1; i++) {
            for (int j = y - 1; j < x + 1; j++) {
                GameObject aux = _board.objectAt(i, j);
                if (aux != null) {
                    aux.increasePower();
                }
            }
        }
    }

    public boolean garlicPush() {
        if (_pl.getCoins() >= 10) {
            _board.garlicPush();
            return true;
        } else {
            return false;
        }

    }

    public boolean lightFlash() {
        if (_pl.getCoins() >= 50) {
            _board.lightFlash();
            return true;
        } else {
            return false;
        }
    }

    public void addCoins(int c) {
        _pl.addCoins(c);
        System.out.println(c + " coins added");
    }
}
