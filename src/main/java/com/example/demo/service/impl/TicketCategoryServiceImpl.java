
// package com.example.demo.service.impl;

// import com.example.demo.model.TicketCategory;
// import com.example.demo.repository.TicketCategoryRepository;
// import com.example.demo.service.TicketCategoryService;
// import org.springframework.stereotype.Service;


// @Service
// public class TicketCategoryServiceImpl implements TicketCategoryService {

//     private final TicketCategoryRepository categoryRepository;

//     public TicketCategoryServiceImpl(TicketCategoryRepository categoryRepository) {
//         this.categoryRepository = categoryRepository;
//     }

//     @Override
//     public TicketCategory createCategory(TicketCategory category) {
//         if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
//             throw new RuntimeException("category already exists");
//         }
//         return categoryRepository.save(category);
//     }

//     @Override
//     public TicketCategory getCategory(Long id) {
//         return categoryRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("category not found"));
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
