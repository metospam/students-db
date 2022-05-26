package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsService;

import java.util.List;

@Component("saveAction")
@Scope("prototype")
@RequiredArgsConstructor
public class SaveAction implements Action {

    private final DaoService<Student> studentDaoService;
    private final DaoService<Group> groupDaoService;
    private final StudentsService studentsService;
    private final GroupService groupService;

    @Override
    public void setParams(String... params) {

    }

    @Override
    public void execute() {
        saveStudents();
        //saveGroups();

        System.out.println("Save DB.");
        System.out.print(">");
    }

    private void saveStudents() {
        List<Student> allStudents = studentsService.findAll();
        allStudents.forEach(studentDaoService::save);
    }

   // private void saveGroups(){
       // List<Group> allGroups = groupService.findAll();
     //   allGroups.forEach(groupDaoService::save);
   // }
}