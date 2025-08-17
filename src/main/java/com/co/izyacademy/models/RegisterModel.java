package com.co.izyacademy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterModel {
    private String name;
    private String username;
    private String country;
    private String city;
    private String idNumber;
    private String phone;
    private String email;
    private String password;
}
