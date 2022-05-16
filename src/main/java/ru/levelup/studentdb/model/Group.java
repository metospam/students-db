package ru.levelup.studentdb.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Group {
    private final String name;

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        student.setGroup(this);
        students.add(student);
    }

    @Override
    public String toString(){
        return name;
    }
}