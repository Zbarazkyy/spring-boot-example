package com.example.springbootexample.model.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long Id;
    private String name;
    private String password;
}
