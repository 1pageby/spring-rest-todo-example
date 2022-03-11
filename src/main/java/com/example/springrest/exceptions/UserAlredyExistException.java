package com.example.springrest.exceptions;

public class UserAlredyExistException extends Exception{

    public UserAlredyExistException(String message) {
        super(message);
    }
}
