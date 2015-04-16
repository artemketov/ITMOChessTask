package ru.ifmo.ketov;

public class FigureRook extends Figure {
    public boolean checkStep(Cell from, Cell to) {
        if (from.j == to.j || from.i == to.i) {
            return true;
        } else {
            return false;
        }
    }
}
