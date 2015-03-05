import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //постоянно путаюсь с i и j - потом надо исправить. пока первое - i (вертикаль)
        Task task1 = new Task (new Cell(3, 6), new Cell(2, 4));
        // первые два числа - откуда ходим, вторые - куда должны сходить
        // (реализована пока только проверка на существование хода, поэтому эти цифры ни на что не влияют).
        // Пока так

        int i;
        int a; int b;
        int j;
        Field f = new Field(task1);
        Scanner sc = new Scanner(System.in);
        f.printField();
        System.out.println ("Введите координаты фигуры, которой будете ходить:");
        System.out.println("Введите букву (пока цифру)");
        a = sc.nextInt();

        System.out.println("Введите цифру");
        b = sc.nextInt();

        System.out.println ("Введите координаты поля, куда будете ходить:");


        System.out.println("Введите букву (пока цифру)");
        j = sc.nextInt();

        System.out.println("Введите цифру");
        i = sc.nextInt();

        //координаты, которые должен передать пользователь
        try {
           f.step(new Cell(b, a), new Cell(i, j)); }
       catch (Exception e) {
           System.out.println("Эта фигура так не ходит!"); }


        f.printField();
    }
}
