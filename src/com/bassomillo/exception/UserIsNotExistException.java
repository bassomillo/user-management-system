package com.bassomillo.exception;

public class UserIsNotExistException extends RuntimeException{
    public UserIsNotExistException(){
        super("user not exist");
    }
}
