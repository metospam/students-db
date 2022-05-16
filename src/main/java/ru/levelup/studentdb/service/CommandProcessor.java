package ru.levelup.studentdb.service;

public interface CommandProcessor {
    void process(String name, String cmd, String... args);
}