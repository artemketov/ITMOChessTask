package ru.ifmo.ketov;

public interface Command {
    public void execute(Cell cell) throws Exception;
}
//execute без параметров, везде, где есть этот метод добавить конструктор с принятием this.cell = cell