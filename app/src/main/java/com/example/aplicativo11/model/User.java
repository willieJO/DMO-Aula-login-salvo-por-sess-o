package com.example.aplicativo11.model;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private static final String TAG = User.class.getSimpleName();

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User() {}

    public User(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    public void generatePassword(String pass) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(pass.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
             this.password = hexString.toString();
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG,"Erro no encoding");
            this.password = pass;
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG,"ALgoritimo SHA-256 não encontrado");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        User other = (User) obj;
        boolean equal = false;
        if (other.getUsername().equals(this.username)) {
            if (other.getPassword().equals((this.password))) {
                equal = true;
            }
        }
        return equal;
    }

    public static boolean autenticate(User userSystem,User userLogin) {
        return userSystem.getUsername().equals(userLogin);
    }

}
