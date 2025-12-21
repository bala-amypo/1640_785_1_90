package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TicketCategoryService;

@Service
public class TicketCategoryServiceImpl implements UserService {

    @Autowired
    private UserRepository used;

    @Override
    public User registerUser1(User user) {
        return used.save(user);
    }

    @Override
    public List<User> getAllUsers1() {
        return used.findAll();
    }

    @Override
    public String userDelete1(Long id) {
        used.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public User getUser1(Long id) {
        return used.findById(id).orElse(null);
    }

    @Override
    public User userUpdate1(Long id, User user) {
        if (used.existsById(id)) {
            user.setId(id);
            return used.save(user);
        }
        return null;
    }
}

