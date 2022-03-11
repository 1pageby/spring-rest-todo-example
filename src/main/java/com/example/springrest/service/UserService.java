package com.example.springrest.service;

import com.example.springrest.entity.UserEntity;
import com.example.springrest.exceptions.UserAlredyExistException;
import com.example.springrest.exceptions.UserNotFoundException;
import com.example.springrest.model.User;
import com.example.springrest.repository.UserRepo;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    /**
     * New User Registration
     * @param user
     * @return
     * @throws UserAlredyExistException
     */
    public UserEntity registration(UserEntity user) throws UserAlredyExistException {

        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlredyExistException("User alredy exist");
        }
        return userRepo.save(user);
    }

    /**
     * Get one user by id
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    public User getUserById(Long id) throws UserNotFoundException {
        try{
            UserEntity user = userRepo.findById(id).get();
            if(user == null){
                throw new UserNotFoundException("User not found");
            }
            return User.toModel(user);
        }catch (NoSuchElementException e){
            throw new UserNotFoundException("User not found");
        }

    }

    /**
     * Delete one user by id
     * @param id
     * @return
     */
    public Long deleteUserById(Long id){
        userRepo.deleteById(id);
        return id;
    }

}
