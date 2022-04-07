package com.example.exercise.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {


    @Query("SELECT i FROM Todo i WHERE i.username = ?1")
    Optional<Todo> findInternByUsername(String username);


}
