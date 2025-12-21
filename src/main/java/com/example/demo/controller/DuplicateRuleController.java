package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DuplicateRule;
import com.example.demo.service.DuplicateRuleService;

@RestController
@RequestMapping("/duplicaterule")
public class DuplicateRuleController {

    @Autowired
    private DuplicateRuleService sev;

    @PostMapping
    public DuplicateRule createUser(@RequestBody DuplicateRule user) {
        return sev.registerUser3(user);
    }

    @GetMapping
    public List<DuplicateRule> getAllUsers() {
        return sev.getAllUsers3();
    }

    @GetMapping("/{id}")
    public DuplicateRule getUser(@PathVariable Long id) {
        return sev.getUser3(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return sev.userDelete3(id);
    }

    @PutMapping("/{id}")
    public DuplicateRule updateUser(@PathVariable Long id,
                                     @RequestBody DuplicateRule user) {
        return sev.userUpdate3(id, user);
    }
}
