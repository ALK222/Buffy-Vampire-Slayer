package objects;

public class SlayerList {

    // Attributes
    private Slayer[] _list;
    private int _counter;

    public SlayerList() {
        _list = new Slayer[10];
        _counter = 0;
    }

    protected void add(Slayer aux) {
        _list[_counter] = aux;
        _counter++;
    }

}
