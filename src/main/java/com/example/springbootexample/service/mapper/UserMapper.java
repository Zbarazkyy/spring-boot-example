package com.example.springbootexample.service.mapper;

import com.example.springbootexample.model.User;
import com.example.springbootexample.model.dto.UserRequestDto;
import com.example.springbootexample.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setPassword(user.getPassword());
        return responseDto;
    }

    public User toModel(UserRequestDto userRequestDto) {
         User user = new User();
         user.setName(userRequestDto.getName());
         user.setPassword(userRequestDto.getPassword());
         return user;
    }
}
