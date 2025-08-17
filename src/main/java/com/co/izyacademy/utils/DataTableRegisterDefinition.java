package com.co.izyacademy.utils;

import com.co.izyacademy.models.RegisterModel;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableRegisterDefinition {
    @DataTableType
    public RegisterModel registerModelEntry(Map<String, String> entry) {
        return RegisterModel.builder()
                .name(entry.get("name"))
                .username(entry.get("username"))
                .country(entry.get("country"))
                .city(entry.get("city"))
                .idNumber(entry.get("idNumber"))
                .phone(entry.get("phone"))
                .email(entry.get("email"))
                .password(entry.get("password"))
                .build();
    }
}
