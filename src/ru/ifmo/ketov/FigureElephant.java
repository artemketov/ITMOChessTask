package ru.ifmo.ketov;

import static java.lang.Math.abs;

public class
        FigureElephant extends Figure {

    FigureElephant(Side side) {
        this.side = side;
        this.type = Type.Elephant;
    }

    public boolean checkStep(Cell from, Cell to) {
        if (abs(from.j - to.j) == abs(from.i - to.i)) return true;
        else return false;
    }
}
