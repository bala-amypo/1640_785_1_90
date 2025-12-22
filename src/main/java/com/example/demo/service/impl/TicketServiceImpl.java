package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository used;

    @Override
    public Ticket registerUser2(Ticket user) {
        return used.save(user);
    }

    @Override
    public List<Ticket> getAllUsers2() {
        return used.findAll();
    }

    @Override
    public String userDelete2(Long id) {
        used.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public Ticket getUser2(Long id) {
        return used.findById(id).orElse(null);
    }

    @Override
    public Ticket userUpdate2(Long id, Ticket user) {
        if (used.existsById(id)) {
            user.setId(id);
            return used.save(user);
        }
        return null;
    }
}
