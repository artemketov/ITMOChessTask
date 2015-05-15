package ru.ifmo.ketov;

import java.util.HashMap;
import java.util.Map;

public class Field {
    public static final HashMap<String, Integer> columnIndexes = new HashMap<>();
    static {
        columnIndexes.put("A", 1);
        columnIndexes.put("B", 2);
        columnIndexes.put("C", 3);
        columnIndexes.put("D", 4);
        columnIndexes.put("E", 5);
        columnIndexes.put("F", 6);
        columnIndexes.put("G", 7);
        columnIndexes.put("H", 8);
    }

    public static final HashMap<Integer, String> columnNames = new HashMap<>();
    static {
        columnNames.put(1, "A");
        columnNames.put(2, "B");
        columnNames.put(3, "C");
        columnNames.put(4, "D");
        columnNames.put(5, "E");
        columnNames.put(6, "F");
        columnNames.put(7, "G");
        columnNames.put(8, "H");
    }

    int n = 9;
    Figure[][] field;

    Field() {
        init();
    }

    private void init() {
        this.field = new Figure[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                field[i][j] = new Figure();
            }
        }
    }

    void setField(HashMap<Cell, Task.FigureConfig> startConfig) {
        init();

        for (Map.Entry<Cell, Task.FigureConfig> entry : startConfig.entrySet()) {
            setCell(entry.getKey(), createFigure(entry.getValue().side, entry.getValue().type));
        }
    }

    Figure getFigure(int i, int j) {
        if (i == 0 || j == 0)
            return null;

        return field[i][j];
    }

    void setCell(Cell cell, Figure figure) {
        field[cell.i][cell.j] = figure;
    }

    Figure cellType(int i, int j) {
        return field[i][j];
    }

    public Figure createFigure(Figure.Side side, Figure.Type type) {
        switch (type) {
            case Pawn: {
                return new FigurePawn(side);
            }
            case King: {
                return new FigureKing(side);
            }
            case Queen: {
                return new FigureQueen(side);
            }
            case Horse: {
                return new FigureHorse(side);
            }
            case Elephant: {
                return new FigureElephant(side);
            }
            case Rook: {
                return new FigureRook(side);
            }
            case Null: {
                return new FigureNull();
            }
        }

        return new Figure();
    }

    public void makeStep(Cell from, Cell to) throws Exception {
        if (field[from.i][from.j].type != Figure.Type.Null
                && !(from.i == to.i && from.j == to.j)
                && field[from.i][from.j].checkStep(from, to)) {
            field[to.i][to.j] = field[from.i][from.j];
            field[from.i][from.j] = createFigure(Figure.Side.Null, Figure.Type.Null);
        } else {
            throw new Exception();
        }
    }


    // выводим текущее игровое поле
//    void printField() {
//
//        System.out.print("# ");
//        System.out.print("A ");
//        System.out.print("B ");
//        System.out.print("C ");
//        System.out.print("D ");
//        System.out.print("E ");
//        System.out.print("F ");
//        System.out.print("G ");
//        System.out.print("H ");
//
//        System.out.println();
//
//        for (int i = 1; i < n; i++) {
//            System.out.print(i + " ");
//            for (int j = 1; j < n; j++) {
//                char c = '.';
//                switch (field[i][j].type) {
//                    case Horse: {
//                        c = 'H';
//                        break;
//                    }
//                    case King: {
//                        c = 'K';
//                        break;
//                    }
//                    case Pawn: {
//                        c = 'P';
//                        break;
//                    }
//                    case Queen: {
//                        c = 'Q';
//                        break;
//                    }
//                    case Elephant: {
//                        c = 'E';
//                        break;
//                    }
//                    case Rook: {
//                        c = 'R';
//                        break;
//                    }
//                }
//
//
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }


}
