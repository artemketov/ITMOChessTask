package ru.ifmo.ketov;

public class FigureHorse extends Figure {

    FigureHorse(Side side) {
        this.side = side;
        this.type = Type.Horse;
    }

    public boolean checkStep(Cell from, Cell to) {
        return from.j == to.j + 1 && from.i == to.i + 2 ||
                from.j == to.j + 2 && from.i == to.i + 1 ||
                from.j == to.j - 1 && from.i == to.i + 2 ||
                from.j == to.j + 1 && from.i == to.i - 2 ||
                from.j == to.j - 1 && from.i == to.i - 2 ||
                from.j == to.j + 2 && from.i == to.i - 1 ||
                from.j == to.j - 2 && from.i == to.i + 1 ||
                from.j == to.j - 2 && from.i == to.i - 1;
    }
}
