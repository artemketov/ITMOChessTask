package ru.ifmo.ketov;

public interface Command{
    public void execute(Field field, Cell from, Cell to) throws Exception;
}