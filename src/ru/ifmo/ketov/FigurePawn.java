package ru.ifmo.ketov;

public class FigurePawn extends Figure {

    FigurePawn(Side side) {
        this.side = side;
        this.type = Type.Pawn;
    }

    public boolean checkStep(Cell from, Cell to) {
//        return true;
        return (((from.j == to.j) && (from.i == to.i + 1 && side == Side.White ||
                from.i == to.i + 2 && side == Side.White && from.i == 7 ||
                from.i == to.i - 1 && side == Side.Black ||
                from.i == to.i - 2 && side == Side.Black && from.i == 2)));
//               || (side == Side.White && from.i == to.i + 1 && from.j == to.j + 1 && from.j == to.j - 1 && (field.getFigure(to.j, to.i) = Type.Null ));

    }
}
