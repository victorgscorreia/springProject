package com.learning.springProject.exceptions;

public class ClientException extends RuntimeException{

    public ClientException(Long id){

        super("User not found: " + id);

    }

}
