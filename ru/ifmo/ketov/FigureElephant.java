package ru.ifmo.ketov;

import static java.lang.Math.abs;

public class FigureElephant extends Figure {

    FigureElephant(Side side) {
        this.side = side;
        this.type = Type.Elephant;
    }

    public boolean checkStep(Cell from, Cell to) {
        return abs(from.j - to.j) == abs(from.i - to.i);
    }
}
