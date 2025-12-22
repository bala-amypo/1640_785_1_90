package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository used;

    @Override
    public User registerUser(User user) {
        return used.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return used.findAll();
    }

    @Override
    public String userDelete(Long id) {
        used.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public User getUser(Long id) {
        return used.findById(id).orElseThrow(()->new NotFoundException("Not Found"));
    }

    @Override
    public User userUpdate(Long id, User user) {
        if (used.existsById(id)) {
            user.setId(id);
            return used.save(user);
        }
        return null;
    }
}

