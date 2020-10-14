package Logic;

import java.util.Random;

import Objects.Player;
import Objects.Vampire;

public class Game {

    // Attributes
    private int _dimX;
    private int _dimY;
    private int _cycle;
    private long _seed;
    private Level _lvl;
    private Player _pl;
    private Random _rand;

    // String tags
    private static String cycleNum = "Number of cycles: ";
    private static String coinStr = "Coins ";
    private static String vampStr = "Remaining vampires: ";
    private static String vampOnBoardStr = "Vampires on the board: ";

    public Game(String l, String seed) {
        _cycle = 0;
        _lvl = Level.parse(l);
        _seed = Long.parseLong(seed);
        _rand = new Random(_seed);
        _pl = new Player(this, 0);
        Vampire.setNumVamp(_lvl.getNumVamp());
        Vampire.setOnBoard(0);
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
            // Spawn new vampire
        }
        Vampire.getNumVamp();
        _cycle++;
    }

    public void printInfo() {
        System.out.println(cycleNum + _cycle); // Display for the number of the current game cycle
        System.out.print(coinStr + _pl.getCoins()); // Display of the current coin counter
        System.out.println(vampStr + Vampire.getNumVamp()); // Display of the number of vampires remaining to spawn
        System.out.println(vampOnBoardStr + Vampire.getOnBoard()); // Display of the number of vampires on the board
    }

    public boolean checkEnd() {
        return true;
    }
}
