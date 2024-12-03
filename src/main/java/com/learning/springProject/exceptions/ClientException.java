package com.learning.springProject.exceptions;

public class ClientException extends RuntimeException{

    public ClientException(){

        super("User not found");

    }

}
