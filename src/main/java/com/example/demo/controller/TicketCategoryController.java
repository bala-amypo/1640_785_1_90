package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/Category")
public class TicketCategoryController {

    @Autowired
    private TicketCategoryService ser;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return ser.registerUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return ser.getAllData();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return ser.getUser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return ser.userDelete(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return ser.userUpdate(id, user);
    }
}
