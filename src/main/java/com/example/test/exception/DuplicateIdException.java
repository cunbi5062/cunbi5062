package com.example.test.exception;

public class DuplicateIdException extends RuntimeException{
    public DuplicateIdException(String message){
        super(message);
    }
}