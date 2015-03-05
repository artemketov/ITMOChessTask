
// i - координата Y
// j - координата X
//  import java.util.concurrent.ExecutionException;

public class Field {

    Task task;

    // размер поля
    int n = 9;
    // массив для поля
    Figure[][] field;

//    int[] m = {"A", "B", };




    // конструктор, который строит поле
    Field(Task task) {
        this.task = task;
        field = new Figure[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                field[i][j] = new Figure();
            }
        }
        // фигуры для теста ходов
        setCell(new Cell(2, 2), new Figure(Figure.Side.Black, Figure.Type.King));
        setCell(new Cell(2, 1), new Figure(Figure.Side.White, Figure.Type.Pawn));
        setCell(new Cell(5, 5), new Figure(Figure.Side.Black, Figure.Type.Pawn));
        setCell(new Cell(3, 3), new Figure(Figure.Side.Black, Figure.Type.Rook));
        setCell(new Cell(8, 8), new Figure(Figure.Side.Black, Figure.Type.Elephant));
        setCell(new Cell(6, 3), new Figure(Figure.Side.Black, Figure.Type.Horse));
        setCell(new Cell(2, 7), new Figure(Figure.Side.Black, Figure.Type.Queen));


    }

    // методы задания и получения значения ячейки поля
    void setCell(Cell cell, Figure figure) {
        field[cell.i][cell.j] = figure;
    }

    //проверка на правильность
    public boolean step(Cell from, Cell to) {
        if (!field[from.i][from.j].checkStep(from, to)) {
            throw new RuntimeException("step error");
        }

        field[to.i][to.j] =  field[from.i][from.j];
        field[from.i][from.j] = new Figure();
        if (task.check(from, to)) {
            System.out.println("Правильно");
            return true;
        } else {
            return false;
        }
    }

    // метод возвращает значение ячейки, вдруг понадобится
    Figure cellType(int i, int j) {
        return field[i][j];
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
