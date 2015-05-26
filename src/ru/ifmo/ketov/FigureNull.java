package ru.ifmo.ketov;

public class FigureNull extends Figure {

    FigureNull(Side side) {
        this.side = side;
        this.type = Type.Null;
    }

    public boolean checkStep(Cell from, Cell to) {

        return false;
    }
}
