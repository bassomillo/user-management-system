package com.bassomillo.exception;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(){
        super("wrong password");
    }
}
