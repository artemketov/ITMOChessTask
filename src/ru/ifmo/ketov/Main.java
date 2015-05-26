package ru.ifmo.ketov;

public class Main {

    public static void main(String[] args) {

        Field field = new Field();

        Task[] taskList = new Task[]{
                new Task1("Начальная расстановка", field),
                new Task2("Ход слоном", field),
                new Task3("Мат в один ход за черных", field),
                new Task4("Ход пешкой", field),
                new Task5("Мат в один ход за белых", field),
                new Task6("Уход от шаха", field)
        };

        Window myWindow = new Window(field, taskList);

        myWindow.changeComboBox(taskList[0]);
        myWindow.setVisible(true);

    }
}
