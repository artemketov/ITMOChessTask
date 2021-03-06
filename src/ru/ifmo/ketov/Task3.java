package ru.ifmo.ketov;

import java.util.HashMap;

public class Task3 extends Task {


    public Task3(String config, Field field) {

        this.field = field;
        name = config;
        setConfig();
        message = getTaskMessage();
        count = 1;

    }

    public void setConfig() {
        startConfig = new HashMap<>();

        startConfig.put(new Cell(6, 7), new FigureConfig(Figure.Side.Black, Figure.Type.King));
        startConfig.put(new Cell(8, 8), new FigureConfig(Figure.Side.White, Figure.Type.King));
//        for (int o = 1; o < 9; o++) {
//            startConfig.put(new Cell(2, o), new FigureConfig(Figure.Side.Black, Figure.Type.Pawn));
//        }
//        for (int o = 1; o < 9; o++) {
//            startConfig.put(new Cell(7, o), new FigureConfig(Figure.Side.White, Figure.Type.Pawn));
//        }
        startConfig.put(new Cell(1, 1), new FigureConfig(Figure.Side.Black, Figure.Type.Rook));
//        startConfig.put(new Cell(1, 8), new FigureConfig(Figure.Side.Black, Figure.Type.Rook));
//
//        startConfig.put(new Cell(8, 1), new FigureConfig(Figure.Side.White, Figure.Type.Rook));
//        startConfig.put(new Cell(8, 8), new FigureConfig(Figure.Side.White, Figure.Type.Rook));
//
//        startConfig.put(new Cell(1, 3), new FigureConfig(Figure.Side.Black, Figure.Type.Elephant));
//        startConfig.put(new Cell(1, 6), new FigureConfig(Figure.Side.Black, Figure.Type.Elephant));
//
//        startConfig.put(new Cell(8, 3), new FigureConfig(Figure.Side.White, Figure.Type.Elephant));
//        startConfig.put(new Cell(8, 6), new FigureConfig(Figure.Side.White, Figure.Type.Elephant));
//
//        startConfig.put(new Cell(1, 2), new FigureConfig(Figure.Side.Black, Figure.Type.Horse));
//        startConfig.put(new Cell(1, 7), new FigureConfig(Figure.Side.Black, Figure.Type.Horse));
//
//        startConfig.put(new Cell(8, 7), new FigureConfig(Figure.Side.White, Figure.Type.Horse));
//        startConfig.put(new Cell(8, 2), new FigureConfig(Figure.Side.White, Figure.Type.Horse));
//
//        startConfig.put(new Cell(8, 4), new FigureConfig(Figure.Side.White, Figure.Type.Queen));
//        startConfig.put(new Cell(1, 4), new FigureConfig(Figure.Side.Black, Figure.Type.Queen));
    }

    public boolean check() {
        return ((field.getFigure(8, 1).type == Figure.Type.Rook)
                && (field.getFigure(8, 1).side == Figure.Side.Black));
    }

    String getTaskMessage() {
        return "Поставьте мат белому королю в один ход";
    }
}

