package ru.ifmo.ketov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Task {

    Window window;
    Field field;
    String name;
    int count;
    String message;
    HashMap<Cell, FigureConfig> startConfig;
//    int t = 0;

    static final class FigureConfig {
        Figure.Side side;
        Figure.Type type;

        FigureConfig(Figure.Side side, Figure.Type type) {
            this.side = side;
            this.type = type;
        }
    }

    String getTaskMessage() {
        return message;
    }

    public Task() {

    }

    public int counter() {
        return count;
    }

    public void run() {
        field.setField(startConfig);
    }

    public boolean check() {

        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
