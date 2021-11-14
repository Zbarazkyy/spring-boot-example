package com.example.springbootexample.service;

import com.example.springbootexample.model.User;
import com.example.springbootexample.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
