package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TicketCategory;
import com.example.demo.service.TicketCategoryService;

@RestController
@RequestMapping("/categories")
public class TicketCategoryController {

    @Autowired
    private TicketCategoryService ser;

    @PostMapping
    public TicketCategory createUser(@RequestBody TicketCategory user) {
        return ser.registerUser(user);
    }

    @GetMapping
    public List<TicketCategory> getAllUsers() {
        return ser.getAllData();
    }

    @GetMapping("/{id}")
    public TicketCategory getUser(@PathVariable Long id) {
        return ser.getUser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return ser.userDelete(id);
    }

    @PutMapping("/{id}")
    public TicketCategory updateUser(@PathVariable Long id, @RequestBody TicketCategory user) {
        return ser.userUpdate(id, user);
    }
}
