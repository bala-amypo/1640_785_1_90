package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TicketCategory;
import com.example.demo.service.TicketCategoryService;

@RestController
@RequestMapping("/ticketcategories")
public class TicketCategoryController {

    @Autowired
    private TicketCategoryService ser;

    @PostMapping
    public TicketCategory createUser(@RequestBody TicketCategory category) {
        return ser.registerUser(category);
    }

    @GetMapping
    public List<TicketCategory> getAllCategories() {
        return ser.getAllData();
    }

    @GetMapping("/{id}")
    public TicketCategory getUser(@PathVariable Long id) {
        return ser.getUser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTicketCategory(@PathVariable Long id) {
        return ser.ticketcategoryDelete(id);
    }

    @PutMapping("/{id}")
    public TicketCategory updateTicketCategory(@PathVariable Long id, @RequestBody TicketCategory category) {
        return ser.ticketcategoryUpdate(id, user);
    }
}
