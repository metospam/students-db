package ru.levelup.studentdb.service;

import java.util.Collection;
import java.util.List;

public interface DaoService<T> {
    T save(T data);
    Collection<T> findAll();
}
