package ru.levelup.studentdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Group {

    private Long id;
    private String name;
    private List<Student> students;

    public Group(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, List<Student> students){
        this.name = name;
        this.students = students;
    }

    @Override
    public String toString(){
        return name;
    }
}