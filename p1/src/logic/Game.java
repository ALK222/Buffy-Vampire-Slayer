package logic;

import java.util.Random;

import objects.GameObjectBoard;
import objects.Player;
import objects.Slayer;
import objects.Vampire;

public class Game {

    // Attributes
    private int _dimX;
    private int _dimY;
    private static final int _VAMPIREHEALTH = 5;
    private int _cycle;
    private long _seed;
    private Level _lvl;
    private Player _pl;
    private Random _rand;

    private GameObjectBoard _board;

    // String tags
    private static String cycleNum = "Number of cycles: ";
    private static String coinStr = "Coins ";
    private static String vampStr = "Remaining vampires: ";
    private static String vampOnBoardStr = "Vampires on the board: ";

    public Game(Long seed, Level l) {
        _cycle = 0;
        _lvl = l;
        _seed = seed;
        _dimX = _lvl.getX();
        _dimY = _lvl.getY();
        _rand = new Random(_seed);
        _pl = new Player(this, 0);
        Vampire.setNumVamp(_lvl.getNumVamp());
        Vampire.setOnBoard(0);
        _board = new GameObjectBoard(this);
    }

    // Methods
    public void update() {
        if (_rand.nextDouble() >= 0.5) {
            _pl.addCoins(10);
        }
        // Vampires advance

        // Slayers attack
        // Vampires attack

        if (_rand.nextDouble() <= _lvl.getFreq() && Vampire.getNumVamp() > 0) {
            int x = _rand.nextInt(_dimX);
            int y = _dimY - 1;
            while (_board.vampIn(x, y)) {
                x = _rand.nextInt(_dimX);
            }
            Vampire aux = new Vampire(_VAMPIREHEALTH, x, y);
            _board.add(aux);
        }
        _cycle++;
    }

    public void printInfo() {
        System.out.println(cycleNum + _cycle); // Display for the number of the current game cycle
        System.out.print(coinStr + _pl.getCoins()); // Display of the current coin counter
        System.out.println(vampStr + Vampire.getNumVamp()); // Display of the number of vampires remaining to spawn
        System.out.println(vampOnBoardStr + Vampire.getOnBoard()); // Display of the number of vampires on the board
    }

    public boolean checkEnd() {
        if (Vampire.getNumVamp() == 0 && Vampire.getOnBoard() == 0) {
            return true;
        }
        if (_board.haveLanded()) {
            return true;
        }
        return false;
    }

    public boolean addSlayer() {
        if (_pl.getCoins() <= Slayer.getCost()) {
            // Add Slayer to array
            _pl.decCoins(Slayer.getCost());
            return true;
        }

        return false;
    }

    public int getNumVamps() {
        return _lvl.getNumVamp();
    }

    public String characterAtToString(int i, int j) {
        return _board.toString(i, j);
    }
}
