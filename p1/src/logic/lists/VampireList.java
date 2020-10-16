package logic.lists;

import logic.objects.Vampire;

/**
 * List of al the vampires on the board
 */
public class VampireList {

    private Vampire[] _list;

    /**
     * 
     * @param size max number of vampires that can be in the board at a time
     */
    public VampireList(int size) {
        _list = new Vampire[size];
        Vampire.setOnBoard(0);
    }

    /**
     * 
     * @return true if a vampire has arrived to the final column, false if not
     */
    public boolean haveLanded() {
        for (int i = 0; i < Vampire.getOnBoard(); i++) {
            if (_list[i].hasArrived()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a vampire to the array
     * 
     * @param aux vampire to be added
     */
    public void add(Vampire aux) {
        _list[Vampire.getOnBoard()] = aux;
        Vampire.decreaseRem(1);
        Vampire.addOnBoard(1);
    }

    /**
     * Checks if in the given coordinates is any vampire
     * 
     * @param x x coordinate
     * @param y y coordinate
     * @return true if there is a vampire in that location, false if not
     */
    public int isIn(int x, int y) {
        int i = 0;
        while (i < Vampire.getOnBoard()) {
            if (_list[i].getX() == x && _list[i].getY() == y) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * string of a vampire of the board
     * 
     * @param n position of the vampire in the array
     * @return Vampire string
     */
    public String toString(int n) {
        return _list[n].toString();
    }

    /**
     * Movement of al the vampires on the board
     */
    public void movement() {
        for (int i = 0; i < Vampire.getOnBoard(); i++) {
            _list[i].movement();
        }
    }

    /**
     * Attack inflicted to a vampire
     * 
     * @param n position of the vampire on the array
     * @param d damage taken by the vampire
     */
    public void attackVamp(int n, int d) {
        _list[n].damage(d);
    }

    /**
     * Executes the attacks of all vampires
     */
    public void attack() {
        for (int i = 0; i < Vampire.getOnBoard(); i++) {
            _list[i].attack();
        }
    }

    /**
     * Resets the vampire list
     */
    public void reset() {
        Vampire.setOnBoard(0);
    }

    /**
     * Removes the dead vampires from the game
     */
    public void removeDead() {
        int deleted = 0;
        for (int i = 0; i < Vampire.getOnBoard(); i++) {
            if (_list[i].getHp() <= 0) {
                deleteVampire(i);
                deleted++;
            }
        }
        Vampire.decOnBoard(deleted);
    }

    /**
     * Aux method for removeDead
     */
    public void deleteVampire(int i) {
        if (Vampire.getOnBoard() > 1) {
            for (int n = i; n < Vampire.getOnBoard() - 1; n++) {
                _list[n] = _list[n + 1];
            }
        }
    }

}
