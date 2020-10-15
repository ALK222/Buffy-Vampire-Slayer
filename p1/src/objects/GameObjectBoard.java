package objects;

import logic.Game;

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

    public boolean vampIn(int x, int y) {
        return _vList.isIn(x, y);
    }

}
