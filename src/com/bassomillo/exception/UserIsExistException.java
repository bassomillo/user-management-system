package com.bassomillo.exception;

public class UserIsExistException extends RuntimeException{
    public UserIsExistException(){
        super("user has already exist");
    }
}
