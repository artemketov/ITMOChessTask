package ru.ifmo.ketov;

import static java.lang.Math.abs;

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
//    public void figureType (Type type) {
//        return Figure.type;
//    }

   public boolean checkStep(Cell from, Cell to) {
//
//   switch (type) {
//            case Pawn: {
//               // return checkPawnStep(from, to);
//            }
//            case King: {
//                //return checkKingStep(from, to);
//            }
//            case Queen: {
//              //  return checkQueenStep(from, to);
//            }
//            case Horse: {
//               // return checkHorseStep(from, to);
//            }
//            case Elephant: {
//               // return checkElephantStep(from, to);
//            }
//            case Rook: {
//               // return checkRookStep(from, to);
//            }
//
//
//        }
        return true;
    }



    //алгоритмы ходов
    // !!!!!!!!!!!!!!!!!!!НЕ ПРОПИСАНО УСЛОВИЕ, КОГДА ОДНА ФИГУРА РУБИТ ДРУГУЮ!!!!!!!!!!!!!!!!!!!


    // int k
}
