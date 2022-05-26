package ru.levelup.studentdb.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.actions.Action;
import ru.levelup.studentdb.service.CommandProcessor;

import java.util.Arrays;

@Component
public class CommandProcessorImpl implements CommandProcessor, ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Override
    public void process(String cmd, String... args) {
        Object actionObject = ctx.getBean(cmd + "Action");

        if (actionObject instanceof Action) {
            Action action = (Action) actionObject;

            if (args.length > 1) {
                action.setParams(Arrays.copyOfRange(args, 0, args.length));
            }

            action.execute();

        } else {
            System.out.println("Unknown");
        }
    }
}
