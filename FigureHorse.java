package ru.ifmo.ketov;

public class FigureHorse extends Figure {
    public boolean checkStep(Cell from, Cell to) {
        if (from.j == to.j + 1 && from.i == to.i + 2 ||
                from.j == to.j + 2 && from.i == to.i + 1 ||
                from.j == to.j - 1 && from.i == to.i + 2 ||
                from.j == to.j + 1 && from.i == to.i - 2 ||
                from.j == to.j - 1 && from.i == to.i - 2 ||
                from.j == to.j + 2 && from.i == to.i - 1 ||
                from.j == to.j - 2 && from.i == to.i + 1 ||
                from.j == to.j - 2 && from.i == to.i - 1) {
            return true;

        } else {
            return false;
        }
    }
}
