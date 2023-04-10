package com.example.aplicativo11.Exception;

public class UserNotFound extends Exception{
    public UserNotFound(String message) {
        super("Usuario não encontrado");
    }
}
