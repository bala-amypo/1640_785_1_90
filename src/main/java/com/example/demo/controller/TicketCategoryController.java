package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TicketCategory;
import com.example.demo.service.TicketCategoryService;

@RestController
@RequestMapping("/Category")
public class TicketCategoryController {

    @Autowired
    private TicketCategoryService ser;

    @PostMapping
    public TicketCategory createUser(@RequestBody TicketCategory user) {
        return ser.registerUser1(user);
    }

    @GetMapping
    public List<TicketCategory> getAllUsers1() {
        return ser.getAllData();
    }

    @GetMapping("/{id}")
    public TicketCategory getUser1(@PathVariable Long id) {
        return ser.getUser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser1(@PathVariable Long id) {
        return ser.userDelete(id);
    }

    @PutMapping("/{id}")
    public TicketCategory updateUser1(@PathVariable Long id, @RequestBody TicketCategory user) {
        return ser.userUpdate(id, user);
    }
}
