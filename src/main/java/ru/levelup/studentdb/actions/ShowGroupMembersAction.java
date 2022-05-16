package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.service.GroupService;

import java.util.List;

@Component("show membersAction")
@Scope("prototype")
@RequiredArgsConstructor
public class ShowGroupMembersAction implements Action {

    private final GroupService groupService;

    private String groupName;

    @Override
    public void setParams(String... param) {
        groupName = param[0];
    }

    @Override
    public void execute() {
        List<Group> groups = groupService.findAll();
        if(groups.size() > 0) {
            groups.stream()
                    .filter(group -> group.getName().equals(groupName))
                    .map(Group::getStudents)
                    .forEach(System.out::println);
        } else {
            System.out.println("Groups not exists.");
        }
    }
}