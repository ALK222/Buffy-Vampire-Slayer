package view;

import logic.Game;
import logic.interfaces.IPrintable;

public class Stringifier extends GamePrinter {

    final String space = " ";

    private IPrintable _game;

    public Stringifier(Game game) {
        _game = game;
    }

    public Stringifier() {

    }

    public void setGame(Game g) {
        _game = g;
    }

    public String toString() {

        String stringify = "Buffy the Vampire Slayer v3.0";
        stringify += "\n" + _game.getSerializeInfo();
        stringify += "\nGame Object List: \n";
        stringify += _game.stringify();
        return stringify;
    }

}
