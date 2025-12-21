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
    private TicketCategoryService sev;

    @PostMapping
    public TicketCategory createUser(@RequestBody TicketCategory user) {
        return sev.registerUser1(user);
    }

    @GetMapping
    public List<TicketCategory> getAllUsers() {
        return sev.getAllUsers1();
    }

    @GetMapping("/{id}")
    public TicketCategory getUser(@PathVariable Long id) {
        return sev.getUser1(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return sev.userDelete1(id);
    }

    @PutMapping("/{id}")
    public TicketCategory updateUser(@PathVariable Long id,
                                     @RequestBody TicketCategory user) {
        return sev.userUpdate1(id, user);
    }
}
