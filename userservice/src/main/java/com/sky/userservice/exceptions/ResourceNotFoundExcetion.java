package com.sky.userservice.exceptions;

public class ResourceNotFoundExcetion extends RuntimeException{

    public ResourceNotFoundExcetion(){
        super("Resource not found on server !!");
    }

    public ResourceNotFoundExcetion(String message){
        super(message);
    }
}
