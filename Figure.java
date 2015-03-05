
public class Figure {
    public enum Type {Null, Pawn, King, Queen, Elephant, Horse, Rook} //Pawn - пешка

    //Rook - ладья
    public enum Side {
        Null, Black, White
    }

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
        switch (type) {
            case Pawn: {
                return checkPawnStep(from, to);
            }
            case King: {
                return checkKingStep(from, to);
            }
            case Queen: {
                return checkQueenStep(from, to);
            }
            case Horse: {
                return checkHorseStep(from, to);
            }
            case Elephant: {
                return checkElephantStep(from, to);
            }
            case Rook: {
                return checkRookStep(from, to);
            }


        }
        return false;
    }

    //алгоритмы ходов
    // !!!!!!!!!!!!!!!!!!!НЕ ПРОПИСАНО УСЛОВИЕ, КОГДА ОДНА ФИГУРА РУБИТ ДРУГУЮ!!!!!!!!!!!!!!!!!!!
    private boolean checkPawnStep(Cell from, Cell to) {
        if ((from.j == to.j) && (from.i == to.i + 1 && side == Side.Black ||
                from.i == to.i + 2 && side == Side.Black && from.i == 7 ||
                from.i == to.i - 1 && side == Side.White ||
                from.i == to.i - 2 && side == Side.White && from.i == 2)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkKingStep(Cell from, Cell to) {
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

    int k;
//к сожалению, слон не правильно работает
    private boolean checkQueenStep(Cell from, Cell to) {
        if (from.j == to.j + k && from.i == to.i + k ||
                from.j == to.j - k && from.i == to.i - k ||
                from.j == to.j + k && from.i == to.i - k ||
                from.j == to.j - k && from.i == to.i + k ||
                from.j == to.j || from.i == to.i) {
            return true;
        } else {
            return false;
        }
    }
//к сожалению, слон не правильно работает

    private boolean checkElephantStep(Cell from, Cell to) {
        if (from.j == to.j + k && from.i == to.i + k ||
                from.j == to.j - k && from.i == to.i - k ||
                from.j == to.j + k && from.i == to.i - k ||
                from.j == to.j - k && from.i == to.i + k) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkHorseStep(Cell from, Cell to) {
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

    private boolean checkRookStep(Cell from, Cell to) {
        if (from.j == to.j || from.i == to.i) {
            return true;
        } else {
            return false;
        }
    }
}
