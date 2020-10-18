package logic;

import logic.lists.SlayerList;
import logic.lists.VampireList;
import logic.objects.Slayer;
import logic.objects.Vampire;

/**
 * Board of the game, where al the moves and attacks are calculated
 */
public class GameObjectBoard {

    private VampireList _vList;
    private SlayerList _sList;
    private Game _game;

    /**
     * 
     * @param game instance of the current game
     */
    public GameObjectBoard(Game game) {
        _game = game;
        _vList = new VampireList(_game.getNumVamps());
        _sList = new SlayerList();
    }

    /**
     * Checks if the vampires had arrived to de final column
     * 
     * @return true if they have, false if not
     */
    public boolean haveLanded() {
        return _vList.haveLanded();
    }

    /**
     * Adds a vampire to the board
     * 
     * @param aux vampire to add
     */
    public void add(Vampire aux) {
        _vList.add(aux);
    }

    /**
     * Adds a slayer to the board
     * 
     * @param aux slayer to add
     */
    public void add(Slayer aux) {
        _sList.add(aux);
    }

    /**
     * Searchs if a vampire is in a given set of coordinates
     * 
     * @param i x coordinate
     * @param j y coordinate
     * @return the position on the array of the vampire in that point or -1 if there
     *         is no vampire in that point
     */
    public int vampIn(int x, int y) {
        return _vList.isIn(x, y);
    }

    /**
     * Returns a string with the character at a given point
     * 
     * @param i x coordinate
     * @param j y coordinate
     * @return The string representation of a character or a black string if there
     *         is no character there
     */
    public String toString(int i, int j) {
        int n = _vList.isIn(j, i);
        if (n != -1) {
            return _vList.toString(n);
        }
        n = _sList.isIn(j, i);
        if (n != -1) {
            return _sList.toString(n);
        }
        return "";
    }

    /**
     * Executes the movement of all vampires
     */
    public void vampMovement() {
        _vList.movement();
    }

    /**
     * Searchs if a Slayer is in a given set of coordinates
     * 
     * @param i x coordinate
     * @param j y coordinate
     * @return the position on the array of the slayer in that point or -1 if there
     *         is no slayer in that point
     */
    public int slayerIn(int i, int j) {
        return _sList.isIn(i, j);
    }

    /**
     * Executes an attack on a vampire
     * 
     * @param n number of the vampire on the list
     * @param d damage that the vampire will take
     */
    public void attackVamp(int n, int d) {
        _vList.attackVamp(n, d);
    }

    /**
     * Exectues all the slayers attacks
     */
    public void slayerAttacks() {
        _sList.attack();
    }

    /**
     * Exectues all the slayers attacks
     */
    public void vampAttacks() {
        _vList.attack();
    }

    /**
     * Executes an attack on a slayer
     * 
     * @param n number of the slayer on the list
     * @param d damage that the slayer will take
     */
    public void attackSlayer(int n, int d) {
        _sList.attackSlayer(n, d);
    }

    /**
     * Resets the board
     */
    public void reset() {
        _sList.reset();
        _vList.reset();
    }

    /**
     * Remove dead objects from both lists
     */
    public void removeDead() {
        _sList.removeDead();
        _vList.removeDead();
    }

    /**
     * 
     * @return true if the slayer array is complete, false if not
     */
    public boolean slayerComplete() {
        return _sList.getCounter() >= _sList.getSize() - 1;
    }

}
