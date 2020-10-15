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
    public SlayerList() {
        _list = new Slayer[10];
        _counter = 0;
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
        boolean found = false;
        while (!found && n < _counter) {
            if (_list[n].getX() == i && _list[i].getY() == j) {
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

}
