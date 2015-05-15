package ru.ifmo.ketov;

import javax.swing.*;
import java.awt.*;

public class StepCommand implements Command {

    public enum State {WaitStart, WaitEnd}

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
    }

    public void execute(Cell cell) {
        if (state == State.WaitStart) {
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
            } catch (ArrayIndexOutOfBoundsException e) {
                window.textMessage.setText("Такой колонки нет!");
            } catch (Exception e) {
                window.textMessage.setText("Эта фигура так не ходит!");
            }

            window.setButtonBorder(startCell, 0);
            window.update();
            if (task.check()) {
                window.textMessage.setText("Вы выполнили задание!");
            }

            startCell = null;
        }
    }
}
