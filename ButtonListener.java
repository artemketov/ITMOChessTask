package ru.ifmo.ketov;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private Cell cell;
    private Field field;

    public ButtonListener(Cell cell, Field field) {
        this.cell = cell;
        this.field = field;
    }

    public void actionPerformed(ActionEvent e) {
        Figure figure = field.getFigure(cell.i, cell.j);
        System.out.println(cell.i + " " + cell.j + ": " + figure.type.toString() + " - " + figure.side.toString());
    }
}
