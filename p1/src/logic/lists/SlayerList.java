package logic.lists;

import logic.objects.Slayer;

public class SlayerList {

    // Attributes
    private Slayer[] _list;
    private int _counter;

    public SlayerList() {
        _list = new Slayer[10];
        _counter = 0;
    }

    public void add(Slayer aux) {
        _list[_counter] = aux;
        _counter++;
    }

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

    public String toString(int n) {
        return _list[n].toString();
    }

    public void attack() {
        for (int i = 0; i < _counter; i++) {
            _list[i].attack();
        }
    }

}