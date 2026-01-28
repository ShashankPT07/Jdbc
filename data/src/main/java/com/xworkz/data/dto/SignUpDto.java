package com.xworkz.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String name;
    private String surname;
    private long phoneNumber;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;
}
