package ru.ifmo.ketov;

public interface Command {
    public void execute(Cell cell) throws Exception;
}