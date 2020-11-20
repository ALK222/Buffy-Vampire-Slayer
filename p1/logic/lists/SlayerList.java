package logic.lists;

import logic.objects.Slayer;

/**
 * List of all the slayers on the board
 */
public class SlayerList {

    // Attributes
    private Slayer[] _list;
    private int _counter;

    /**
     * constructor of the list
     */
    public SlayerList(int x, int y) {
        _list = new Slayer[x * y];
        _counter = 0;
    }

    // Getters

    /**
     * 
     * @return the size of the Slayer array
     */
    public int getSize() {
        return _list.length;
    }

    /**
     * 
     * @return the actual number of slayers in the array
     */
    public int getCounter() {
        return _counter;
    }

    /**
     * Adds a slayer to the board
     * 
     * @param aux slayer to be added
     */
    public void add(Slayer aux) {
        _list[_counter] = aux;
        _counter++;
    }

    /**
     * Checks if in the given coordinates is any slayer
     * 
     * @param x x coordinate
     * @param y y coordinate
     * @return true if there is a slayer in that location, false if not
     */
    public int isIn(int i, int j) {
        int n = 0;
        while (n < _counter) {
            if (_list[n].getX() == i && _list[n].getY() == j) {
                return n;
            }
            n++;
        }
        return -1;
    }

    /**
     * string of a slayer of the board
     * 
     * @param n position of the slayer in the array
     * @return Slayer string
     */
    public String toString(int n) {
        return _list[n].toString();
    }

    /**
     * Executes the attacks of every slayer on the board
     */
    public void attack() {
        for (int i = 0; i < _counter; i++) {
            _list[i].attack();
        }
    }

    /**
     * Inflicts an attack on a slayer
     * 
     * @param n position of the slayer on the array
     * @param d damage that the slayer will take
     */
    public void attackSlayer(int n, int d) {
        _list[n].damage(d);
    }

    /**
     * Resets the slayer list
     */
    public void reset() {
        _counter = 0;
    }

    /**
     * Removes the dead slayers from the game
     */
    public void removeDead() {
        int deleted = 0;
        for (int i = 0; i < _counter; i++) {
            if (_list[i].getHp() <= 0) {
                deleteSlayer(i);
                deleted++;
            }
        }
        _counter -= deleted;
    }

    /**
     * Aux method for removeDead
     */
    public void deleteSlayer(int i) {
        if (_counter > 1) {
            for (int n = i; n < _counter - 1; n++) {
                _list[n] = _list[n + 1];
            }
        }
    }

}
