package com.xworkz.data.service;

import com.xworkz.data.repo.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInValidation {

    @Autowired
    private Database database;

    public boolean validate(String username, String password) {
        String dbPassword = database.getPasswordByUsername(username);

        if (dbPassword == null) return false; // Username not found

        return dbPassword.equals(password);
    }
}
