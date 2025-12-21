package com.example.demo.controller;

import com.example.demo.model.TicketCategory;
import com.example.demo.service.TicketCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class TicketCategoryController {

    private final TicketCategoryService ser;

    public TicketCategoryController(TicketCategoryService ser) {
        this.ser = ser;
    }

    @PostMapping
    public TicketCategory create(@RequestBody TicketCategory category) {
        return ser.create(category);
    }

    @GetMapping
    public List<TicketCategory> getAll() {
        return ser.getAll();
    }

    @GetMapping("/{id}")
    public TicketCategory getById(@PathVariable Long id) {
        return ser.getById(id);
    }

    @PutMapping("/{id}")
    public TicketCategory update(@PathVariable Long id,
                                 @RequestBody TicketCategory category) {
        return ser.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ser.delete(id);
    }
}
