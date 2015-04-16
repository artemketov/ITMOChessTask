package ru.ifmo.ketov;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {
//    private JPanel createPanel(Border border, String text) {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        panel.add(new JButton(text));
//        panel.setBorder(new CompoundBorder(new EmptyBorder(12, 12, 12, 12), border));
//        return panel;
//    }

    private Field field;
    private JButton[][] buttons;
    private JPanel panel;

    public Window(final Field field) {

        super("Chess by Ketov");
        this.field = field;

        panel = new JPanel();
        buttons = new JButton[9][9];

        panel.setLayout(new GridLayout(9, 9, 0, 0));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                buttons[i][j] = new JButton();
                panel.add(buttons[i][j]);

                ActionListener actionListener = new ButtonListener(new Cell(i, j), field);
                buttons[i][j].addActionListener(actionListener);

                if (i != 0 && j != 0) {
                    if ((i + j) % 2 == 0) {
                        buttons[i][j].setBackground(new Color(185, 176, 66));
                    } else {
                        buttons[i][j].setBackground(new Color(52, 30, 28));
                        buttons[i][j].setForeground(new Color(255, 255, 255));
                    }
                } else {

                }

            }
        }

        update();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(700, 700);
    }

    public void update() {
//        int n = 9;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                final String s;
                Figure figure = field.cellType(i, j);

                if (figure == null) {
                    if (i == 0 && j == 0) {
                        s = "#";
                    } else if (i == 0) {
                        s = Field.columnNames.get(j).toString();
                    } else if (j == 0) {
                        s = Integer.toString(i);
                    } else {
                        s = "Warning!";
                    }
                } else {
                    if (figure.type == Figure.Type.Null) {
                        s = "";
                    } else {
                        s = figure.type.toString();
                    }

                }

                buttons[i][j].setText(s);
            }
//        panel.add(createPanel(new LineBorder(Color.BLACK, 4), "_"));

        }


    }
}
