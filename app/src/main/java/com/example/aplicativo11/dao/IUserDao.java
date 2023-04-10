package com.example.aplicativo11.dao;

import com.example.aplicativo11.Exception.UserDuplicateException;
import com.example.aplicativo11.model.User;

import java.util.List;

public interface IUserDao {
    public boolean create(User user) throws UserDuplicateException;
    public User findBYUsername(String username);
    public List<User> findALl();
}
