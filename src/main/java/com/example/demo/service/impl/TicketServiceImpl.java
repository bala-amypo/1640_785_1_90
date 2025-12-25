// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.Ticket;
// import com.example.demo.repository.TicketRepository;
// import com.example.demo.service.TicketService;

// @Service
// public class TicketServiceImpl implements TicketService {

//     @Autowired
//     private TicketRepository used;

//     @Override
//     public Ticket registerUser2(Ticket user) {
//         return used.save(user);
//     }

//     @Override
//     public List<Ticket> getAllUsers2() {
//         return used.findAll();
//     }

//     @Override
//     public String userDelete2(Long id) {
//         used.deleteById(id);
//         return "Deleted successfully";
//     }

//     @Override
//     public Ticket getUser2(Long id) {
//         return used.findById(id).orElse(null);
//     }

//     @Override
//     public Ticket userUpdate2(Long id, Ticket user) {
//         if (used.existsById(id)) {
//             user.setId(id);
//             return used.save(user);
//         }
//         return null;
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepo;
    private final UserRepository userRepo;
    private final TicketCategoryRepository categoryRepo;

    public TicketServiceImpl(TicketRepository t, UserRepository u, TicketCategoryRepository c) {
        this.ticketRepo = t;
        this.userRepo = u;
        this.categoryRepo = c;
    }

    public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
        if (ticket.getDescription() == null || ticket.getDescription().length() < 10) {
            throw new RuntimeException("Description too short");
        }
        ticket.setUser(userRepo.findById(userId).orElseThrow());
        ticket.setCategory(categoryRepo.findById(categoryId).orElseThrow());
        return ticketRepo.save(ticket);
    }

    public Ticket getTicket(Long id) {
        return ticketRepo.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    public List<Ticket> getTicketsByUser(Long userId) {
        return ticketRepo.findByUser_Id(userId);
    }
}
