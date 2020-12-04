package logic.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * "Board" of the game.
 * 
 * <p>
 * This class acts as an intermediary between the game and the objects, or one
 * object and another
 */
public class GameObjectBoard {

    // ATTRIBUTES

    private ArrayList<GameObject> _board;
    private final int _maxElements;
    private static final String completeMsg = "Board full";

    // CONSTRUCTOR
    /**
     * Constructor for the GameObjectBoard class
     * 
     * @param width  width of the board
     * @param heigth heigth of the board
     */
    public GameObjectBoard(int width, int heigth) {
        _board = new ArrayList<GameObject>(width * heigth);
        _maxElements = width * heigth;
    }

    // GETTERS
    /**
     * 
     * @return the total number of objects on board
     */
    public int getObjectsOnBoard() {
        return _board.size();
    }

    /**
     * 
     * @return if the board is complete
     */
    public boolean isComplete() {
        return _board.size() <= _maxElements;
    }

    public static String getFullMsg() {
        return completeMsg;
    }

    // METHODS

    /**
     * Checks if the vampires have arraived to the end of the board
     * 
     * @return true if a vampire is in x = -1, false if not
     */
    public boolean haveLanded() {
        boolean found = false;
        int i = 0;

        while (!found && i < _board.size()) {
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
    public GameObject objectAt(int i, int j) {
        boolean found = false;
        int index = 0;

        while (!found && index < _board.size()) {
            if (_board.get(index).getX() == i && _board.get(index).getY() == j) {
                return _board.get(index);
            }
            index++;
        }
        return null;
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

        while (!found && index < _board.size()) {
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
     * @param i y coordinate
     * @param j x coordinate
     * @return the string of an object in that coordinates, a whitespace character
     *         if no object was in place
     */
    public String toString(int i, int j) {
        return (objectAt(j, i) != null) ? objectAt(j, i).toString() : " ";
    }

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
        for (int i = 0; i < _board.size(); i++) {
            _board.get(i).computerAction();
        }
        removeDead();
    }

    /**
     * Removes al the dead objects from the array
     */
    public void removeDead() {
        List<GameObject> auxlist = new ArrayList<GameObject>(_board.size());
        for (int i = 0; i < _board.size(); i++) {
            if (_board.get(i).getHp() <= 0) {
                auxlist.add(_board.get(i));
            }
        }
        _board.removeAll(auxlist);
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
        _board.clear();
    }

    /**
     * Executes a GarlicPush on the board
     */
    public void garlicPush() {
        for (int i = 0; i < _board.size(); i++) {
            _board.get(i).receiveGarlicPush();
        }
    }

    /**
     * Exectues a LightFlash on the board
     */
    public void lightFlash() {
        for (int i = 0; i < _board.size(); i++) {
            _board.get(i).receiveLightAttack();
        }
    }

}
