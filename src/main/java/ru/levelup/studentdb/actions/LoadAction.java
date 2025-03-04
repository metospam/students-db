package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsService;

@Component("loadAction")
@Scope("prototype")
@RequiredArgsConstructor
public class LoadAction implements Action {

    private final StudentsService studentsService;
    private final DaoService<Student> studentDaoService;
    private final DaoService<Group> groupDaoService;
    private final GroupService groupService;

    @Override
    public void setParams(String... params) {

    }

    @Override
    public void execute() {
        studentDaoService.findAll().forEach(studentsService::save);
        groupDaoService.findAll().forEach(groupService::save);


    }
}



