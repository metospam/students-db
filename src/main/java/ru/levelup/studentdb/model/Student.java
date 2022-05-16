package ru.levelup.studentdb.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student {
    private final String firstName;
    private final String lastName;

    private Group group;

    public void setGroup(Group group){
        this.group = group;
    }

    @Override
    public String toString(){
        return  firstName + " " + lastName;
    }
}