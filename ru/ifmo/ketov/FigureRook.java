package ru.ifmo.ketov;

public class FigureRook extends Figure {

    FigureRook(Side side) {
        this.side = side;
        this.type = Type.Rook;
    }

    public boolean checkStep(Cell from, Cell to) {
        return from.j == to.j || from.i == to.i;
    }
}
