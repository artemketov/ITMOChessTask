package ru.ifmo.ketov;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

public class StepCommand implements Command {

    public enum State {WaitStart, WaitEnd}

    boolean b = false;
    State state;
    Cell startCell;

    Window window;
    Task task;

    StepCommand(Window window) {
        this.window = window;

        state = State.WaitStart;
        task = null;
    }

    void setTask(Task task) {
        this.task = task;
        task.run();
        b = false;
        window.update();
    }

    public void execute(Cell cell) {
        if (!b) {

            window.textMessage.setText(task.getTaskMessage());

            if ((state == State.WaitStart)) {

                if (cell.i == 0 || cell.j == 0 || window.field.getFigure(cell.i, cell.j) == null
                        || window.field.getFigure(cell.i, cell.j).type == Figure.Type.Null)
                    return;

                state = State.WaitEnd;
                startCell = cell;
                window.setButtonBorder(startCell, 2);
            } else {
                state = State.WaitStart;


                try {
                    window.field.makeStep(startCell, cell);
                    if (task.counter() == 1) {
                        window.textMessage.setText("Ход корректен, но не решает задание. Попробуйте другой ход");

                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    window.textMessage.setText("Такой колонки нет!");
                } catch (Exception e) {
                    window.textMessage.setText("Эта фигура так не ходит!");
                }

                window.setButtonBorder(startCell, 0);
                window.update();
                if (task.check()) {
                    window.textMessage.setText("Вы выполнили задание! Выберите другое");
                    b = true;
                } else {
                    if (task.counter() == 1) {

                        task.run();
                        window.update();

                    }
                }

                startCell = null;
            }
        }
    }


}
