

// package com.example.demo.service.impl;

// import com.example.demo.model.Ticket;
// import com.example.demo.model.TicketCategory;
// import com.example.demo.model.User;
// import com.example.demo.repository.TicketCategoryRepository;
// import com.example.demo.repository.TicketRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.TicketService;
// import org.springframework.stereotype.Service;


// import java.util.List;

// @Service
// public class TicketServiceImpl implements TicketService {

//     private final TicketRepository ticketRepository;
//     private final UserRepository userRepository;
//     private final TicketCategoryRepository categoryRepository;

//     public TicketServiceImpl(TicketRepository ticketRepository,
//                              UserRepository userRepository,
//                              TicketCategoryRepository categoryRepository) {
//         this.ticketRepository = ticketRepository;
//         this.userRepository = userRepository;
//         this.categoryRepository = categoryRepository;
//     }

//     @Override
//     public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
//         User user = userRepository.findById(userId)
//                 .orElseThrow(() -> new RuntimeException("user not found"));
//         TicketCategory category = categoryRepository.findById(categoryId)
//                 .orElseThrow(() -> new RuntimeException("category not found"));

//         if (ticket.getDescription() == null || ticket.getDescription().length() < 10) {
//             throw new RuntimeException("description too short");
//         }

//         ticket.setUser(user);
//         ticket.setCategory(category);
//         return ticketRepository.save(ticket);
//     }

//     @Override
//     public Ticket getTicket(Long id) {
//         return ticketRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("ticket not found"));
//     }

//     @Override
//     public List<Ticket> getAllTickets() {
//         return ticketRepository.findAll();
//     }

//     @Override
//     public List<Ticket> getTicketsByUser(Long userId) {
//         return ticketRepository.findByUser_Id(userId);
//     }
// }



package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, CategoryRepository categoryRepository) {
        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Ticket createTicket(CreateTicketRequest request) {
        // Validate category exists
        Category category = categoryRepository.findById(request.getCategoryId())
            .orElseThrow(() -> new IllegalArgumentException(
                "Category not found with ID: " + request.getCategoryId()));

        // Validate required fields
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket title is required");
        }

        // Create ticket
        Ticket ticket = new Ticket();
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setPriority(request.getPriority());
        ticket.setStatus(TicketStatus.OPEN);
        ticket.setCategory(category);
        ticket.setCreatedAt(LocalDateTime.now());

        return ticketRepository.save(ticket);
    }
}
