package com.example.springrest.controller;

import com.example.springrest.entity.TodoEntity;
import com.example.springrest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * Create a new To-Do record
     * @param todo
     * @param userId
     * @return
     */
    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
        @RequestParam Long userId){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("It's doesen't work");
        }
    }

    /**
     * Change completed status for record by id
     * @param id
     * @return
     */
    @PutMapping
    public ResponseEntity compleateTodo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(todoService.compleateTodo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("It's doesen't work");
        }
    }
}
