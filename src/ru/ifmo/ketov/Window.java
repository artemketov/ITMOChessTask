package ru.ifmo.ketov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Window extends JFrame {

    private HashMap<Figure.Side, HashMap<Figure.Type, ImageIcon>> iconConfig;

    public Field field;
    private JButton[][] buttons;
    private StepCommand commander;

    public JLabel textMessage;
    private JComboBox comboBox;

    private ImageIcon noImage;

    public Window(final Field field, final Task[] taskList) {
        super("Chess by Ketov");
        this.field = field;
        this.commander = new StepCommand(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel topBlock = new JPanel();
        panel.add(topBlock, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(9, 9, 0, 0));
        panel.add(grid, BorderLayout.CENTER);

        comboBox = new JComboBox(taskList);
        textMessage = new JLabel("Выберите задание.");

        ActionListener taskSelectorActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeComboBox((Task) comboBox.getSelectedItem());
            }
        };
        comboBox.addActionListener(taskSelectorActionListener);

        topBlock.add(comboBox, BorderLayout.WEST);
        topBlock.add(textMessage, BorderLayout.EAST);

        buttons = new JButton[9][9];
        noImage = new ImageIcon(Window.class.getResource("images/no-image.png"));
        iconConfig = getIconConfig();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                buttons[i][j] = new JButton();
                grid.add(buttons[i][j]);

                ActionListener actionListener = new ButtonListener(new Cell(i, j), commander);
                buttons[i][j].addActionListener(actionListener);

                if (i != 0 && j != 0) {
                    if ((i + j) % 2 == 0) {
                        buttons[i][j].setBackground(new Color(221, 226, 121));
                    } else {
                        buttons[i][j].setBackground(new Color(198, 105, 0));
                        buttons[i][j].setForeground(new Color(255, 248, 253));
                    }
                }
            }
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(700, 700);
    }

    public void changeComboBox(Task newTask) {
        textMessage.setText("\"" + newTask.toString() + "\". " + newTask.message);
        commander.setTask(newTask);
        update();
    }

    public void update() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                final String s;
                Figure figure = field.cellType(i, j);

                if (figure == null) {
                    if (i == 0 && j == 0) {
                        s = "#";
                    } else if (i == 0) {
                        s = Field.columnNames.get(j);
                    } else if (j == 0) {
                        s = Integer.toString(i);
                    } else {
                        s = "Warning!";
                    }

                    buttons[i][j].setText(s);
                } else {
                    if (figure.type != Figure.Type.Null) {
                        buttons[i][j].setIcon(getIcon(figure.side, figure.type));
                    } else {
                        buttons[i][j].setIcon(null);
                    }
                }
            }
        }
    }

    void setButtonBorder(Cell cell, int size) {
        buttons[cell.i][cell.j].setBorder(BorderFactory.createLineBorder(Color.blue, size));
    }

    HashMap<Figure.Side, HashMap<Figure.Type, ImageIcon>> getIconConfig() {
        HashMap<Figure.Side, HashMap<Figure.Type, ImageIcon>> config = new HashMap<>();

        HashMap<Figure.Type, ImageIcon> black = new HashMap<>();
        HashMap<Figure.Type, ImageIcon> white = new HashMap<>();

        black.put(Figure.Type.King, new ImageIcon(Window.class.getResource("images/bk.png")));
        black.put(Figure.Type.Horse, new ImageIcon(Window.class.getResource("images/bh.png")));
        black.put(Figure.Type.Pawn, new ImageIcon(Window.class.getResource("images/bp.png")));
        black.put(Figure.Type.Elephant, new ImageIcon(Window.class.getResource("images/be.png")));
        black.put(Figure.Type.Queen, new ImageIcon(Window.class.getResource("images/bq.png")));
        black.put(Figure.Type.Rook, new ImageIcon(Window.class.getResource("images/br.png")));

        white.put(Figure.Type.King, new ImageIcon(Window.class.getResource("images/wk.png")));
        white.put(Figure.Type.Horse, new ImageIcon(Window.class.getResource("images/wh.png")));
        white.put(Figure.Type.Pawn, new ImageIcon(Window.class.getResource("images/wp.png")));
        white.put(Figure.Type.Elephant, new ImageIcon(Window.class.getResource("images/we.png")));
        white.put(Figure.Type.Queen, new ImageIcon(Window.class.getResource("images/wq.png")));
        white.put(Figure.Type.Rook, new ImageIcon(Window.class.getResource("images/wr.png")));

        config.put(Figure.Side.Black, black);
        config.put(Figure.Side.White, white);

        return config;
    }

    ImageIcon getIcon(Figure.Side side, Figure.Type type) {
        if (iconConfig.get(side).containsKey(type)) {
            return iconConfig.get(side).get(type);
        } else {
            return noImage;
        }
    }
}
