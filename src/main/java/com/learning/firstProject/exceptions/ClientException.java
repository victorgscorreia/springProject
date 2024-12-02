package com.learning.firstProject.exceptions;

public class ClientException extends RuntimeException{

    public ClientException(Long id){

        super("User not found: " + id);

    }

}
