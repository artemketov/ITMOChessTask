package ru.ifmo.ketov;

public class FigureNull extends Figure {

    FigureNull() {
        this.side = Side.Null;
        this.type = Type.Null;
    }

    public boolean checkStep(Cell from, Cell to) {

        return false;
    }
}
