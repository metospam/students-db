package ru.levelup.studentdb.actions;

public interface Action {
    void setParams(String... params);
    void execute();
}
