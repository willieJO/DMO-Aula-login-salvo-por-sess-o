package com.example.aplicativo11.controller;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.aplicativo11.Exception.UserInvalidDate;
import com.example.aplicativo11.Exception.UserNotFound;
import com.example.aplicativo11.dao.IUserDao;
import com.example.aplicativo11.dao.UserDaoImp;
import com.example.aplicativo11.model.User;

public class MainController {
    private Context context;
    private UserDaoImp data;

    public MainController(Context con)
    {
        context = con;
        data = UserDaoImp.getInstance();
    }
    public void  checkColor() {

    }
    public boolean login(String user, String pass) throws UserNotFound, UserInvalidDate
    {
        if (user.equals("") || pass.equals("")) {
            throw new UserInvalidDate("Dados não podem ser nulos");
        }
        User currentUser = new User(user,pass);
        User search = data.findBYUsername(user);
        if (search == null) {
            throw  new UserNotFound("Usuario não encontrado");
        }
        if (User.autenticate(search,currentUser)) {

        } else {
            throw  new UserNotFound("Usuario não encontrado");
        }

        return true;
    }
    public void checkPreferences(EditText user, EditText senha, CheckBox remeber) {

    }
}
