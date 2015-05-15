package ru.ifmo.ketov;

public class Figure {

    public enum Type {Null, Pawn, King, Queen, Elephant, Horse, Rook}

    public enum Side {Null, Black, White}

    Side side;
    Type type;

    Figure() {
        side = Side.Null;
        type = Type.Null;
    }

    Figure(Side side, Type type) {
        this.side = side;
        this.type = type;
    }

    public boolean checkStep(Cell from, Cell to) {
        return true;
    }
}
