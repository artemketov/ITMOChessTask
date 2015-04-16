package ru.ifmo.ketov;

public class StepCommand implements Command {

    public void execute(Field field, Cell from, Cell to) throws Exception {

        if (field.getFigure(from.i, from.j).checkStep(from, to)) {
            field.makeStep(from, to);
        } else {
            throw new Exception();
        }
    }
//    if (Figure.getFigure(from.i, from.j).checkStep(from, to)) {
//        field.makeStep(from, to);
//    } else {
//        throw new Exception();
//    }
//}

}
