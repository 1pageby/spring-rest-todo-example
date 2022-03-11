package com.example.springrest.service;

import com.example.springrest.entity.TodoEntity;
import com.example.springrest.entity.UserEntity;
import com.example.springrest.model.Todo;
import com.example.springrest.repository.TodoRepo;
import com.example.springrest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    /**
     * Create a new To-Do record
     * @param todo
     * @param userId
     * @return
     */
    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    /**
     * Change completed status for record by id
     * @param id
     * @return
     */
    public Todo compleateTodo(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
