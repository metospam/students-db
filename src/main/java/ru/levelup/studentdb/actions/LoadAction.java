package ru.levelup.studentdb.actions;

import org.springframework.stereotype.Component;

@Component("load dbAction")
public class LoadAction implements Action{
    @Override
    public void setParams(String... param) {

    }

    @Override
    public void execute() {
        System.out.println("Load DB.");
    }
}

