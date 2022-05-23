package ru.levelup.studentdb.service;

import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;

import java.util.List;

public interface GroupService {
    void save(Group group);
    List<Group> findAll();
    void add(Group group, Student student);
}
