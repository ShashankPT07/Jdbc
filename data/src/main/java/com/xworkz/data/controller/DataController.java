package com.xworkz.data.controller;

import com.xworkz.data.dto.SignUpDto;
import com.xworkz.data.repo.Database;
import com.xworkz.data.service.SignInValidation;
import com.xworkz.data.service.SignUpValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class DataController {

    @Autowired
    private Database database;

    @Autowired
    private SignUpValidation signUpValidation;

    @Autowired
    private SignInValidation signInValidation;

    public DataController() {
        System.out.println("DataController initialized...");
    }

    @PostMapping("/signup")
    public String signup(SignUpDto dto) {
        boolean valid = signUpValidation.validate(dto);
        if (!valid) return "signup";

        boolean saved = database.save(dto);
        return saved ? "signUpResponse" : "signup";
    }

    @PostMapping("/signin")
    public String signin(@RequestParam String username,
                         @RequestParam String password) {
        boolean valid = signInValidation.validate(username, password);
        return valid ? "signInResponse" : "signin";
    }
}
