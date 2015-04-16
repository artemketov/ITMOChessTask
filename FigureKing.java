package ru.ifmo.ketov;

public class FigureKing extends Figure {
    public boolean checkStep(Cell from, Cell to) {
        if ((from.j == to.j - 1 ||
                from.j == to.j + 1) && (from.i == to.i) ||
                (from.i == to.i - 1 ||
                        from.i == to.i + 1) && (from.j == to.j) ||
                from.j == to.j + 1 && from.i == to.i + 1 ||
                from.j == to.j - 1 && from.i == to.i - 1 ||
                from.j == to.j + 1 && from.i == to.i - 1 ||
                from.j == to.j - 1 && from.i == to.i + 1) {
            return true;
        } else {
            return false;
        }
    }
}
