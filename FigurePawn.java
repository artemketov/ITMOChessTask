package ru.ifmo.ketov;

public class FigurePawn extends Figure {
    public boolean checkStep(Cell from, Cell to) {
        if ((from.j == to.j) && (from.i == to.i + 1 && side == Side.Black ||
                from.i == to.i + 2 && side == Side.Black && from.i == 7 ||
                from.i == to.i - 1 && side == Side.White ||
                from.i == to.i - 2 && side == Side.White && from.i == 2)) {
            return true;
        } else {
            return false;
        }
    }
}
