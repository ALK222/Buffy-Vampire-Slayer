package logic.objects;

/**
 * "Board" of the game
 */
public class GameObjectBoard {

    // Attributes
    private GameObject[] _board;
    private int _objectsOnBoard;

    /**
     * Constructor for the GameObjectBoard class
     * 
     * @param width  width of the board
     * @param heigth heigth of the board
     */
    public GameObjectBoard(int width, int heigth) {
        _board = new GameObject[width * heigth];
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

    public int getIndex(GameObject o) {
        boolean found = false;
        int index = 0;

        while (!found && index < _objectsOnBoard) {
            if (_board[index].equals(o)) {
                return index;
            } else {
                ++index;
            }
        }
        return -1;
    }

    public int isIn(int i, int j) {
        boolean found = false;
        int index = 0;

        while (!found && index < _objectsOnBoard) {
            if (_board[index].getX() == i && _board[index].getY() == j) {
                return index;
            } else {
                ++index;
            }
        }
        return -1;
    }

    public boolean isComplete() {
        return _board.length >= _objectsOnBoard;
    }

    // Methods

    /**
     * Adds object to the board
     * 
     * @param o object added to the board
     */
    public void add(GameObject o) {
        if (isComplete()) {
            _board[_objectsOnBoard] = o;
            ++_objectsOnBoard;
        } else {
            System.out.println("Board complete, cannot add anything else");
        }
    }

    /**
     * Executes the computer action of every object on board
     */
    public void computerAction() {
        for (int i = 0; i < _objectsOnBoard; i++) {
            _board[i].computerAction();
        }
    }

    public boolean haveLanded() {
        boolean found = false;
        int i = 0;

        while (!found && i < _objectsOnBoard) {
            if (_board[i].haveLanded()) {
                found = true;
            }
            i++;
        }
        return found;
    }

    /**
     * 
     * @param i x coordinate
     * @param j y coordinate
     * @return the object at that position, null in location is empty
     */
    private GameObject objectAt(int i, int j) {
        boolean found = false;
        int index = 0;

        while (!found && index < _objectsOnBoard) {
            if (_board[index].getX() == i && _board[index].getY() == j) {
                return _board[index];
            }
            index++;
        }
        return null;
    }

    public String toString(int i, int j) {
        return (objectAt(j, i) == null) ? " " : objectAt(j, i).toString();
    }

    public void removeDead() {
        for (int i = 0; i < _objectsOnBoard; i++) {
            if (_board[i].getHp() <= 0) {
                delete(i);
            }
        }
    }

    public void delete(int i) {
        for (int n = i; n < _objectsOnBoard; ++n) {
            _board[i] = _board[i + 1];
        }
        --_objectsOnBoard;
    }

    public void reset() {
        _objectsOnBoard = 0;
    }

}
