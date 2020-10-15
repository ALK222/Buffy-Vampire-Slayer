package objects;

public class VampireList {

    private Vampire[] _list;
    private int _vampInList;

    public VampireList(int size) {
        _list = new Vampire[3];
    }

    public boolean haveLanded() {
        for (int i = 0; i < _vampInList; i++) {
            if (_list[i].hasArrived()) {
                return true;
            }
        }
        return false;
    }

    public void add(Vampire aux) {
        _list[_vampInList] = aux;
        _vampInList++;
    }

}
