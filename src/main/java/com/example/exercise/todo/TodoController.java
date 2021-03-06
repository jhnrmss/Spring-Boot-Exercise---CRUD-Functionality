package com.example.exercise.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {

    private final TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    //get
    @GetMapping
    public List<Todo> getString(){
        return todoService.getTodo();
    }
    @GetMapping("/{id}")
    public Optional<Todo> getIntern(@PathVariable Integer id){
        return todoService.getInternById(id);
    }
    //post
    @PostMapping
    public void regNewIntern(@RequestBody Todo todo){
        todoService.addNewTodo(todo);
    }
    //delete
    @DeleteMapping(path = "{internId}")
    public void deleteIntern(@PathVariable("internId") Integer internId){
        todoService.deleteIntern(internId);
    }
    //update
    @PutMapping(path = "{internId}")
    public void updateIntern(@PathVariable("internId")  Integer internId, @RequestParam(required = false) String username, @RequestParam(required = false) String description){
        todoService.updateInterns(internId, username, description);

    }


}
