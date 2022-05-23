package ru.levelup.studentdb.service;

import java.util.List;

public interface DaoService<T> {
    void save(T data);
    List<T> findAll();
}
