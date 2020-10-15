package objects;

public class VampireList {

    private Vampire[] _list;
    private int _vampInList;

    public VampireList(int size) {
        _list = new Vampire[3];
    }

    protected boolean haveLanded() {
        for (int i = 0; i < _vampInList; i++) {
            if (_list[i].hasArrived()) {
                return true;
            }
        }
        return false;
    }

    protected void add(Vampire aux) {
        _list[_vampInList] = aux;
        _vampInList++;
    }

    public boolean isIn(int x, int y) {
        int i = 0;
        boolean found = false;
        while (!found || i < _vampInList) {
            if (_list[i].getX() == x && _list[i].getY() == y) {
                found = true;
            }
        }
        return found;
    }

}
