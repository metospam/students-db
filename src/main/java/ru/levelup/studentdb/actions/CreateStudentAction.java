package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.StudentsService;

@Component("createStudentAction")
@Scope("prototype")
@RequiredArgsConstructor
public class CreateStudentAction implements Action {

    private String firstName;
    private String lastName;

    private final StudentsService studentsService;

    @Override
    public void setParams(String... params) {
        this.firstName = params[0];
        this.lastName = params[1];
    }

    @Override
    public void execute() {
        Student student = new Student(firstName, lastName);
        studentsService.save(student);

        System.out.println("Student created.");
        System.out.print(">");
    }
}
