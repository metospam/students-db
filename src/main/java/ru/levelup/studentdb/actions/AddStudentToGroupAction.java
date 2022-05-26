package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        getStudent(students);

        Group group = getGroup(groups);
        Student student = getStudent(students);


            groupService.add(group, student);

            System.out.println("Student " + firstName + " " + lastName + " added to group " + groupName);
            System.out.print(">");
        }

    private Student getStudent(List<Student> students) {
        Optional<Student> equalStudents = students.stream()
                .filter(student -> student.getFirstName().equals(firstName))
                .filter(student -> student.getLastName().equals(lastName))
                .findFirst();

        Student student;
        if(equalStudents.isPresent()) {
            student = equalStudents.get();
        } else {
            student = new Student(firstName, lastName);
            studentsService.save(student);
        }
        return student;
    }

    private Group getGroup(List<Group> groups) {
        Optional<Group> equalGroups = groups.stream()
                .filter(group -> group.getName().equals(groupName))
                .findFirst();

        Group group;
        if(equalGroups.isPresent()) {
            group = equalGroups.get();
        } else {
            group = new Group(groupName);
            groupService.save(group);
        }
        return group;

    }
}