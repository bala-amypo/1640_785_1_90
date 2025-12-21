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
    public List<TicketCategory> getAllUsers() {
        return ser.getAllData1();
    }

    @GetMapping("/{id}")
    public TicketCategory getUser(@PathVariable Long id) {
        return ser.getUser1(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return ser.userDelete1(id);
    }

    @PutMapping("/{id}")
    public TicketCategory updateUser(@PathVariable Long id, @RequestBody TicketCategory user) {
        return ser.userUpdate1(id, user);
    }
}
