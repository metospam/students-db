package ru.levelup.studentdb.actions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.service.ApplicationContextHolder;

import java.util.Arrays;

import static org.springframework.util.StringUtils.capitalize;

@Component("createAction")
@Scope("prototype")
public class CreateAction implements Action {

    private String entity;
    private String[] params;

    @Override
    public void setParams(String... params) {
        if(params.length == 0){
            System.out.println("Unknown entity to create.");
            return;
        }

        this.entity = params[0];
        this.params = Arrays.copyOfRange(params, 1, params.length);
    }

    @Override
    public void execute() {
        ApplicationContext ctx = ApplicationContextHolder.getCtx();

        Object actionObject = ctx.getBean("create" + capitalize(entity) + "Action");

        if (actionObject instanceof Action) {
            Action action = (Action) actionObject;
            action.setParams(params);
            action.execute();
        } else {
            System.out.println("Unknown action.");
        }
    }
}
