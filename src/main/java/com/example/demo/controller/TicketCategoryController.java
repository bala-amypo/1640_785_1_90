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
    public TicketCategory createCategory(@RequestBody TicketCategory category) {
        return ser.createCategory(category);
    }

    @GetMapping
    public List<TicketCategory> getAllCategories() {
        return ser.getAllCategories();
    }

    @GetMapping("/{id}")
    public TicketCategory getCategpry(@PathVariable Long id) {
        return ser.getCategory(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return ser.categoryDelete(id);
    }

    @PutMapping("/{id}")
    public TicketCategory updateCategory(@PathVariable Long id, @RequestBody TicketCategory category) {
        return ser.categoryUpdate(id, category);
    }
}
