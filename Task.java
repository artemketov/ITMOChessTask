package ru.ifmo.ketov;

import java.util.HashMap;
import java.util.Scanner;

public class Task {
    Field field;

    Task(String config) { // file
        this.field = field;

        // File: i j FigureName black/white

        HashMap<Cell, Figure> startConfig = new HashMap<Cell, Figure>();
        startConfig.put(new Cell(2, 2), new Figure(Figure.Side.Black, Figure.Type.King));
        startConfig.put(new Cell(2, 1), new Figure(Figure.Side.White, Figure.Type.Pawn));
        startConfig.put(new Cell(5, 5), new Figure(Figure.Side.Black, Figure.Type.Pawn));
        startConfig.put(new Cell(3, 3), new Figure(Figure.Side.Black, Figure.Type.Rook));
        startConfig.put(new Cell(8, 8), new Figure(Figure.Side.Black, Figure.Type.Elephant));
        startConfig.put(new Cell(6, 3), new Figure(Figure.Side.Black, Figure.Type.Horse));
        startConfig.put(new Cell(2, 7), new Figure(Figure.Side.Black, Figure.Type.Queen));

        this.field = new Field(startConfig);
    }

    public void run() {
        StepCommand command = new StepCommand();
        boolean checking = false;
        while (!checking) {
            try {
                Cell from = readCell();
                Cell to = readCell();

                command.execute(field, from, to);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Такой колонки нет!");
            } catch (Exception e) {
                System.out.println("Эта фигура так не ходит!");
            }

            field.updateWindow();
            checking = check();
        }
        System.out.println("Вы прошли задание!");
    }

    public Cell readCell() {
        int a;
        int b;
        String col;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите координаты.");
        System.out.println("Введите букву:");
        col = sc.nextLine();
        if (!Field.columnIndexes.containsKey(col)) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            a = Field.columnIndexes.get(col);
         //   System.out.println("Введено: " + col + ' ' + a);
            System.out.println("Введите цифру");
            b = Integer.parseInt(sc.nextLine());
        }

        return new Cell(b, a);
    }

    int i = 0;

    public boolean check() {
        i++;
        if (i == 1) {
            return true;
        } else {
            return false;
        }

//        if (this.from == from && this.to == to) {
//            System.out.println("Правильно!");
//            return true;
//        } else {
//            return false;
//        }
    }
}
