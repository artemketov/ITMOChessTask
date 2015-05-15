package ru.ifmo.ketov;

public class FigureKing extends Figure {

    FigureKing(Side side) {
        this.side = side;
        this.type = Type.King;
    }

    public boolean checkStep(Cell from, Cell to) {
        return (from.j == to.j - 1 ||
                from.j == to.j + 1) && (from.i == to.i) ||
                (from.i == to.i - 1 ||
                        from.i == to.i + 1) && (from.j == to.j) ||
                from.j == to.j + 1 && from.i == to.i + 1 ||
                from.j == to.j - 1 && from.i == to.i - 1 ||
                from.j == to.j + 1 && from.i == to.i - 1 ||
                from.j == to.j - 1 && from.i == to.i + 1;
    }
}
