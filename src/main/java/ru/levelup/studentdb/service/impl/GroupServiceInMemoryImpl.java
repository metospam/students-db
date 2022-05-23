package ru.levelup.studentdb.service.impl;

import org.springframework.stereotype.Service;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.GroupService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupServiceInMemoryImpl implements GroupService {

    private final List<Group> groups = new ArrayList<>();

    @Override
    public void save(Group group) {
            groups.add(group);
    }

    @Override
    public List<Group> findAll() {
        return Collections.unmodifiableList(groups);
    }

    @Override
    public void add(Group group, Student student) {
        List<Student> studentsOfGroup = group.getStudents();
        studentsOfGroup.add(student);
    }
}
