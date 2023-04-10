package com.example.aplicativo11.dao;

import android.util.Log;

import com.example.aplicativo11.Exception.UserDuplicateException;
import com.example.aplicativo11.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImp  implements IUserDao{
    private static UserDaoImp instance  =  null;
    private static final String TAG = User.class.getSimpleName();
    private List<User> database;

    private UserDaoImp() {
        database = new ArrayList<>();
    }

    public static UserDaoImp getInstance() {
        if (instance == null) {
            instance = new UserDaoImp();
        }
        return instance;
    }

    @Override
    public boolean create(User user) throws UserDuplicateException {
        if (user != null) {
            User inDatabse = database.stream().
                    filter(x-> x.getUsername().equals(user.getUsername()))
                    .findAny()
                    .orElse(null);
            if (inDatabse != null) {
                Log.e(TAG,"Usuario duplicado");
                throw new UserDuplicateException(user.getUsername());
            }
            database.add(inDatabse);
            return true;
        }
        return false;
    }

    @Override
    public User findBYUsername(String username) {
        return this.database.stream().filter(x -> x.getUsername().equals(username)).findFirst().orElse(null);
    }

    @Override
    public List<User> findALl() {
        return this.database;
    }
}
