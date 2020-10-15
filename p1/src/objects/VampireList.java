package objects;

public class VampireList {

    private Vampire[] _list;
    private int _vampInList;

    public VampireList(int size) {
        _list = new Vampire[3];
    }

    protected boolean haveLanded() {
        for (int i = 0; i < Vampire.getOnBoard(); i++) {
            if (_list[i].hasArrived()) {
                return true;
            }
        }
        return false;
    }

    protected void add(Vampire aux) {
        _list[Vampire.getOnBoard()] = aux;
        Vampire.decreaseRem(1);
        Vampire.addOnBoard(1);
    }

    public int isIn(int x, int y) {
        int i = 0;
        boolean found = false;
        while (!found && i < Vampire.getOnBoard()) {
            if (_list[i].getX() == x && _list[i].getY() == y) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public String toString(int n) {
        return _list[n].toString();
    }

    public void movement() {
        for (int i = 0; i < Vampire.getOnBoard(); i++) {
            _list[i].movement();
        }
    }

}
