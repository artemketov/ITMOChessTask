package ru.ifmo.ketov;
// i - координата Y
// j - координата X

import java.util.HashMap;
import java.util.Iterator;

public class Field {
    public static final HashMap<String, Integer> columnIndexes = new HashMap<String, Integer>();

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

    public static final HashMap<Integer, String> columnNames = new HashMap<Integer, String>();

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


    // размер поля
    int n = 9;
    // массив для поля
    Figure[][] field;
    Window myWindow;


    // конструктор, который строит поле
    Field(HashMap<Cell, Figure> startConfig) {
        this.field = new Figure[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                field[i][j] = new Figure();
            }
        }

        for (Iterator<HashMap.Entry<Cell, Figure>> it = startConfig.entrySet().iterator(); it.hasNext(); ) {
            HashMap.Entry<Cell, Figure> entry = it.next();
            setCell(entry.getKey(), entry.getValue());
        }

        myWindow = new Window(this);
        myWindow.setVisible(true);
    }

    Figure getFigure(int i, int j) {
        return field[i][j];
    }

    // методы задания и получения значения ячейки поля
    void setCell(Cell cell, Figure figure) {
        field[cell.i][cell.j] = figure;
    }

    // метод возвращает значение ячейки
    Figure cellType(int i, int j) {
        return field[i][j];
    }


    public Figure createFigure (Figure.Type type) {
        switch (type) {
            case Pawn: {
                return new FigurePawn();
            }
            case King: {
                return new FigureKing();
            }
            case Queen: {
                return new FigureQueen();
            }
            case Horse: {
                return new FigureHorse();
            }
            case Elephant: {
                return new FigureElephant();
            }
            case Rook: {
                return new FigureRook();
            }
            case Null: {
                return new FigureNull();
            }

        }

        return new Figure();

    }

    public void makeStep(Cell from, Cell to) {
        field[to.i][to.j] = field[from.i][from.j];
        field[from.i][from.j] = createFigure(Figure.Type.Null);
    }

    public void updateWindow() {
        myWindow.update();
    }


    // выводим текущее игровое поле
    void printField() {

        System.out.print("# ");
        System.out.print("A ");
        System.out.print("B ");
        System.out.print("C ");
        System.out.print("D ");
        System.out.print("E ");
        System.out.print("F ");
        System.out.print("G ");
        System.out.print("H ");
//        for (String i = "A"; i < "H"; i++) {
//            System.out.print(i + " ");
//        }

        System.out.println();

        for (int i = 1; i < n; i++) {
            System.out.print(i + " ");
            for (int j = 1; j < n; j++) {
                char c = '.';
                switch (field[i][j].type) {
                    case Horse: {
                        c = 'H';
                        break;
                    }
                    case King: {
                        c = 'K';
                        break;
                    }
                    case Pawn: {
                        c = 'P';
                        break;
                    }
                    case Queen: {
                        c = 'Q';
                        break;
                    }
                    case Elephant: {
                        c = 'E';
                        break;
                    }
                    case Rook: {
                        c = 'R';
                        break;
                    }
                }


                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
