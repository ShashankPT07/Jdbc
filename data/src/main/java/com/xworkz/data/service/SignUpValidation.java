package com.xworkz.data.service;

import com.xworkz.data.dto.SignUpDto;
import org.springframework.stereotype.Service;

@Service
public class SignUpValidation {

    public boolean validate(SignUpDto dto) {

        String name = dto.getName();
        String surname = dto.getSurname();
        long phoneNumber = dto.getPhoneNumber();
        String email = dto.getEmail();
        String username = dto.getUsername();
        String password = dto.getPassword();
        String confirmPassword = dto.getConfirmPassword();

        if (name != null && name.length() >= 3
                && surname != null && surname.length() >= 3
                && phoneNumber > 999999999L // At least 10 digits
                && email != null && email.contains("@")
                && username != null && username.length() >= 4
                && password != null && password.equals(confirmPassword)) {

            System.out.println("Valid signup data");
            return true;
        }

        System.out.println("Invalid signup data");
        return false;
    }
}
