package com.example.springbootexample.service;

import com.example.springbootexample.model.User;
import java.util.List;

public interface UserService {
    User add(User user);

    User get(Long Id);

    List<User> getAll();
}
