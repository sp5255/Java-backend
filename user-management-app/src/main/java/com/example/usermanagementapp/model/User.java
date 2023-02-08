package com.example.usermanagementapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private int userId ;
    private long phone_number;
    private String  name, userName, address;
}
