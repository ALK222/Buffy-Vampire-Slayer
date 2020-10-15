package logic;

import logic.lists.SlayerList;
import logic.lists.VampireList;
import logic.objects.Slayer;
import logic.objects.Vampire;

public class GameObjectBoard {

    private VampireList _vList;
    private SlayerList _sList;
    private Game _game;

    public GameObjectBoard(Game game) {
        _game = game;
        _vList = new VampireList(_game.getNumVamps());
        _sList = new SlayerList();
    }

    public boolean haveLanded() {
        return _vList.haveLanded();
    }

    public void add(Vampire aux) {
        _vList.add(aux);
    }

    public void add(Slayer aux) {
        _sList.add(aux);
    }

    public int vampIn(int x, int y) {
        return _vList.isIn(x, y);
    }

    public String toString(int i, int j) {
        int n = _vList.isIn(j, i);
        if (n != -1) {
            return _vList.toString(n);
        }
        n = _sList.isIn(j, i);
        if (n != -1) {
            return _sList.toString(n);
        }
        return "";
    }

    public void vampMovement() {
        _vList.movement();
    }

    public int slayerIn(int i, int j) {
        return _sList.isIn(i, j);
    }

    public void attackVamp(int n, int d) {
        _vList.attackVamp(n, d);
    }

}
