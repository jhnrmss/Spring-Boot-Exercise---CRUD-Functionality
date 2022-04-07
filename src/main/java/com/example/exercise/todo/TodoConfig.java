package com.example.exercise.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class TodoConfig {
    @Bean //Push a default value in database
    CommandLineRunner commandLineRunner(TodoRepository repository){
        return args -> {
            Todo jror = new Todo(
                    1,
                    "JROR",
                    "Softeng",
                    LocalDate.of(2022, APRIL, 5)
            );
            Todo max = new Todo(
                    2,
                    "Max",
                    "Softeng",
                    LocalDate.of(2022, APRIL, 5)
            );
            repository.saveAll(List.of(jror, max));
        };
    }
}
