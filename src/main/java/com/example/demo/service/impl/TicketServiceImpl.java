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
// }package com.example.demo.service.impl;

import com.example.demo.model.Ticket;
import com.example.demo.model.TicketCategory;
import com.example.demo.model.User;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final TicketCategoryRepository categoryRepository;

    public TicketServiceImpl(TicketRepository ticketRepository,
                             UserRepository userRepository,
                             TicketCategoryRepository categoryRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
        TicketCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("category not found"));

        if (ticket.getDescription() == null || ticket.getDescription().length() < 10) {
            throw new RuntimeException("description too short");
        }

        ticket.setUser(user);
        ticket.setCategory(category);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ticket not found"));
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getTicketsByUser(Long userId) {
        return ticketRepository.findByUser_Id(userId);
    }
}
