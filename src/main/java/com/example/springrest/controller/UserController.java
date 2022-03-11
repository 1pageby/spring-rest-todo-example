package com.example.springrest.controller;

import com.example.springrest.entity.UserEntity;
import com.example.springrest.exceptions.UserAlredyExistException;
import com.example.springrest.exceptions.UserNotFoundException;
import com.example.springrest.repository.UserRepo;
import com.example.springrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * New User Registration
     * @param user
     * @return
     */
    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("The user is saved!");
        }catch (UserAlredyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error saving user");
        }
    }

    /**
     * Get one user by id
     * @param id
     * @return
     */
    @GetMapping
    public ResponseEntity getUserById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("It's doesen't work");
        }
    }

    /**
     * Delete one user by id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteUserById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("It's doesen't work");
        }
    }
}
