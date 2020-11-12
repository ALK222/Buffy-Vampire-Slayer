package logic.objects;

import java.util.ArrayList;

/**
 * "Board" of the game
 */
public class GameObjectBoard {

    // Attributes
    private ArrayList<GameObject> _board;
    private int _objectsOnBoard;

    /**
     * Constructor for the GameObjectBoard class
     * 
     * @param width  width of the board
     * @param heigth heigth of the board
     */
    public GameObjectBoard(int width, int heigth) {
        _board = new ArrayList<GameObject>(width * heigth);
        _objectsOnBoard = 0;
    }

    // Getters
    /**
     * 
     * @return the total number of objects on board
     */
    public int getObjectsOnBoard() {
        return _objectsOnBoard;
    }

    /**
     * 
     * @param i x coordinate
     * @param j y coordinate
     * @return the index of the object in place, -1 if no object was found
     */
    public int isIn(int i, int j) {
        boolean found = false;
        int index = 0;

        while (!found && index < _objectsOnBoard) {
            if (_board.get(index).getX() == i && _board.get(index).getY() == j) {
                return index;
            } else {
                ++index;
            }
        }
        return -1;
    }

    /**
     * 
     * @return if the board is complete
     */
    public boolean isComplete() {
        return _board.size() >= _objectsOnBoard;
    }

    // Methods

    /**
     * Adds object to the board
     * 
     * @param o object added to the board
     */
    public void add(GameObject o) {
        try {
            _board.add(o);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the computer action of every object on board
     */
    public void computerAction() {
        for (int i = 0; i < _objectsOnBoard; i++) {
            _board.get(i).computerAction();
        }
        removeDead();
    }

    /**
     * Checks if the vampires have arraived to the end of the board
     * 
     * @return true if a vampire is in x = -1, false if not
     */
    public boolean haveLanded() {
        boolean found = false;
        int i = 0;

        while (!found && i < _objectsOnBoard) {
            if (_board.get(i).haveLanded()) {
                found = true;
            }
            i++;
        }
        return found;
    }

    /**
     * Founds a object in a coordinate
     * 
     * @param i x coordinate
     * @param j y coordinate
     * @return the object at that position, null in location is empty
     */
    private GameObject objectAt(int i, int j) {
        boolean found = false;
        int index = 0;

        while (!found && index < _objectsOnBoard) {
            if (_board.get(i).getX() == i && _board.get(index).getY() == j) {
                return _board.get(index);
            }
            index++;
        }
        return null;
    }

    /**
     * 
     * @param i y coordinate
     * @param j x coordinate
     * @return the string of an object in that coordinates, a whitespace character
     *         if no object was in place
     */
    public String toString(int i, int j) {
        return (objectAt(j, i) == null) ? " " : objectAt(j, i).toString();
    }

    /**
     * Removes al the dead objects from the array
     */
    public void removeDead() {
        for (int i = 0; i < _objectsOnBoard; i++) {
            if (_board.get(i).getHp() <= 0) {
                delete(i);
            }
        }
    }

    /**
     * Deletes an pbject from the array
     * 
     * @param i position of the dead object in the array
     */
    public void delete(int i) {
        _board.remove(i);
    }

    /**
     * Resets the board
     */
    public void reset() {
        _objectsOnBoard = 0;
    }

    /**
     * PENDING TO CHANGE
     * 
     * @param o     object to make the attack
     * @param other object to receive the attack
     * @return true if the attack can be executed, false if not
     */
    public boolean attack(GameObject o, int other) {
        if (_board.get(other).isVampire() != o.isVampire()) {
            _board.get(other).damage(o.getDamage());
            return true;
        }
        return false;
    }

}
