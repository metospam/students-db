package ru.levelup.studentdb.actions;

import org.springframework.context.ApplicationContext;
import ru.levelup.studentdb.service.ApplicationContextHolder;

import java.util.Arrays;

import static org.springframework.util.StringUtils.capitalize;

//@Component("listAction")
//@Scope("prototype")
public class ListAction implements Action {

    private String entity;
    private String[] params;

    @Override
    public void setParams(String... params) {
        if(params.length == 0){
            System.out.println("Unknown entity to create.");
            return;
        } else if (params.length > 1){
            System.out.println("Unknown args.");
        }

        this.entity = params[0];
        this.params = Arrays.copyOfRange(params, 1, params.length);
    }

    @Override
    public void execute() {
        ApplicationContext ctx = ApplicationContextHolder.getCtx();

        Object actionObject = ctx.getBean("list" + capitalize(entity) + "Action");

        if (actionObject instanceof Action) {
            Action action = (Action) actionObject;
            action.execute();
        } else {
            System.out.println("Unknown action.");
        }
    }
}
