package ru.levelup.studentdb.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.service.CommandProcessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CommandProcessor processor;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please, enter command");
        System.out.print(">");

        //Lukyanov Pavel

        // create student FirstName LastName
        // list students

        // create group GroupName
        // list groups

        // add student FirstName LastName to GroupName
        // show members GroupName

        // save db
        // load db

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!(line = reader.readLine()).equals("exit")) {
            String[] tokens = line.split(" ");
            processor.process(tokens[0], tokens[1], Arrays.copyOfRange(tokens, 1, tokens.length));
        }
        System.out.println();
    }
}
