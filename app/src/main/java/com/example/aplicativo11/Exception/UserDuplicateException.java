package com.example.aplicativo11.Exception;

public class UserDuplicateException extends Exception {
    public UserDuplicateException(String message) {
        super("Usuario duplicado");
    }
}
