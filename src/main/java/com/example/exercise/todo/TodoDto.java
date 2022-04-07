package com.example.exercise.todo;

import lombok.Data;

import java.time.LocalDate;
@Data
public class TodoDto {
    private Integer id;
    private String username;
    private String description;
    private LocalDate targetDate;
}
