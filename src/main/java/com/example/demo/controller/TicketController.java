package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService sev;

    @PostMapping
    public Ticket createUser(@RequestBody Ticket user) {
        return sev.registerUser2(user);
    }

    @GetMapping
    public List<Ticket> getAllUsers() {
        return sev.getAllUsers2();
    }

    @GetMapping("/{id}")
    public Ticket getUser(@PathVariable Long id) {
        return sev.getUser2(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return sev.userDelete2(id);
    }

    @PutMapping("/{id}")
    public Ticket updateUser(@PathVariable Long id,
                                     @RequestBody Ticketuser) {
        return sev.userUpdate2(id, user);
    }
}
