package com.example.FulLstackbackend.Exception;

public class RootException extends RuntimeException{
    public RootException(Long id){
        super("Could not find the user of id "+ id);
    }
}
