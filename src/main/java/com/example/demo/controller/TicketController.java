
// package com.example.demo.controller;

// import com.example.demo.model.Ticket;
// import com.example.demo.service.TicketService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/tickets")
// public class TicketController {

//     private final TicketService ticketService;

//     public TicketController(TicketService ticketService) {
//         this.ticketService = ticketService;
//     }

//     @PostMapping
//     public Ticket createTicket(
//             @RequestParam Long userId,
//             @RequestParam Long categoryId,
//             @RequestBody Ticket ticket) {
//         return ticketService.createTicket(userId, categoryId, ticket);
//     }

//     @GetMapping("/{id}")
//     public Ticket getTicket(@PathVariable Long id) {
//         return ticketService.getTicket(id);
//     }

//     @GetMapping
//     public List<Ticket> getAllTickets() {
//         return ticketService.getAllTickets();
//     }

//     @GetMapping("/user/{userId}")
//     public List<Ticket> getTicketsByUser(@PathVariable Long userId) {
//         return ticketService.getTicketsByUser(userId);
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.CreateTicketRequest;
import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody CreateTicketRequest request) {
        Ticket ticket = ticketService.createTicket(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }
}
