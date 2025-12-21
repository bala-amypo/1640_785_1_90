package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ticket;
import com.example.demo.model.TicketCategory;
import com.example.demo.model.User;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketCategoryRepository categoryRepository;

    @Override
    public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {

        User user = userRepository.findById(userId).orElse(null);
        TicketCategory category = categoryRepository.findById(categoryId).orElse(null);

        if (user == null || category == null) {
            return null;
        }

        ticket.setUser(user);
        ticket.setCategory(category);

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }

    @Override
    public List<Ticket> getTicketsByUser(Long userId) {

        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return List.of();
        }

        return ticketRepository.findByUser(user);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
