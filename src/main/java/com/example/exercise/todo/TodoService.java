package com.example.exercise.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //Get
    public List<Todo> getTodo(){

        return todoRepository.findAll();
    }
    //Get by id
    public Optional<Todo> getInternById(Integer id) {
        return todoRepository.findById(id);
    }
    //Post
    public void addNewTodo(Todo todo) {
        Optional<Todo> internOptional = todoRepository.findInternByUsername(todo.getUsername());
        if(internOptional.isPresent()){
            throw new IllegalStateException("Username taken!");
        }
        todoRepository.save(todo);
    }
    //Delete
    public void deleteIntern(Integer internId) {
        //check if the the intern is existing
        boolean exists = todoRepository.existsById(internId);
        if(!exists){
            throw new IllegalStateException("Intern with ID"+ internId + "does not exists!");
        }
        todoRepository.deleteById(internId);
    }
    //PUT or update database value
    @Transactional
    public void updateInterns(Integer internId, String username, String description) {
        //find user by ID in the data base and collect data and store it in todo variable
        Todo todo = todoRepository.findById(internId).orElseThrow(() -> new IllegalStateException("Intern with id "+ internId
                +" does not exist!"));
            if(username != null && username.length() > 0 && !Objects.equals(todo.getUsername(), username)){
                todo.setUsername(username);
            }
            if(description != null && description.length() > 0 && !Objects.equals(todo.getDescription(), description)){
                todo.setDescription(description);
            }

        }


}
