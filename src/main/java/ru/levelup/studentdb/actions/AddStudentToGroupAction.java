package ru.levelup.studentdb.actions;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsService;

import java.util.List;
import java.util.stream.Collectors;

@Component("add studentAction")
@Scope("prototype")
@RequiredArgsConstructor
public class AddStudentToGroupAction implements Action{

    private final GroupService groupService;
    private final StudentsService studentsService;

    private String firstName;
    private String lastName;
    private String groupName;

    @Override
    public void setParams(String... param) {
        firstName = param[0];
        lastName = param[1];
        groupName = param[3];
        //add student FirstName[0] LastName[1] to[2] GroupName[3]
    }

    @Override
    public void execute() {
        List<Student> students = studentsService.findAll();
        List<Group> groups = groupService.findAll();

        List<Student> equalStudents = students.stream()
                .filter(student -> student.getFirstName().equals(firstName))
                .filter(student -> student.getLastName().equals(lastName))
                .collect(Collectors.toList());

        List<Group> equalGroups = groups.stream()
                .filter(group -> group.getName().equals(groupName))
                .collect(Collectors.toList());

        if(equalStudents.size() > 0 && equalGroups.size() > 0) {

            Group group = equalGroups.get(0);
            Student student = equalStudents.get(0);

            group.addStudent(student);

            System.out.println("Student " + firstName + " " + lastName + " added to group " + groupName);
        } else {
            System.out.println("Group/Student not exists.");
        }
    }
}