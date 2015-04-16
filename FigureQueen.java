package ru.ifmo.ketov;

import static java.lang.Math.abs;

public class FigureQueen extends Figure {
    public boolean checkStep(Cell from, Cell to) {
        if (abs(from.j - to.j) == abs(from.i - to.i) ||
                from.j == to.j || from.i == to.i) {
            return true;
        } else {
            return false;
        }
    }

}
