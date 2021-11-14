package com.example.springbootexample.controller;

import com.example.springbootexample.model.User;
import com.example.springbootexample.model.dto.UserRequestDto;
import com.example.springbootexample.model.dto.UserResponseDto;
import com.example.springbootexample.service.UserService;
import com.example.springbootexample.service.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private UserMapper userMapper;
    private UserService userService;

    @Autowired
    public DemoController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("/test")
    public String testDemo() {
        return "good job";
    }

    @PostMapping("/add")
    public UserResponseDto addUser(@RequestBody UserRequestDto userRequestDto) {
        User userFromDto = userMapper.toModel(userRequestDto);
        User addedUser = userService.add(userFromDto);
        UserResponseDto responseDto = userMapper.toDto(addedUser);
        return responseDto;
    }

    @GetMapping("/get")
    public UserResponseDto get(@RequestParam Long id) {
        return userMapper.toDto(userService.get(id));
    }

    @GetMapping("/all")
    public List<UserResponseDto> all() {
        return userService.getAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
