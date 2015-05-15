package ru.ifmo.ketov;

public class Main {

    public static void main(String[] args) {

        Field field = new Field();

        Task[] taskList = new Task[]{
                new Task1("Начальная расстановка", field),
                new Task2("task2", field),
                new Task3("task3", field)

        };

        Window myWindow = new Window(field, taskList);

        myWindow.changeComboBox(taskList[0]);
        myWindow.setVisible(true);

    }
}
