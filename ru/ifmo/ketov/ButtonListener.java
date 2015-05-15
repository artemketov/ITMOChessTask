package ru.ifmo.ketov;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private Cell cell;
    private StepCommand commander;

    public ButtonListener(Cell cell, StepCommand commander) {
        this.cell = cell;
        this.commander = commander;
    }

    public void actionPerformed(ActionEvent e) {
        commander.execute(cell);
    }
}
