package ru.ifmo.ketov;

import static java.lang.Math.abs;

public class FigureQueen extends Figure {

    FigureQueen(Side side) {
        this.side = side;
        this.type = Type.Queen;
    }

    public boolean checkStep(Cell from, Cell to) {
        return abs(from.j - to.j) == abs(from.i - to.i) ||
                from.j == to.j || from.i == to.i;
    }

}
