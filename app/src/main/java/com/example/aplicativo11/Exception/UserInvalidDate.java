package com.example.aplicativo11.Exception;

public class UserInvalidDate extends  Exception{
    public UserInvalidDate(String message) {
        super("Dados não podem ser vazios");
    }
}
