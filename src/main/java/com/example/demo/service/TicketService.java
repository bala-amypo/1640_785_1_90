// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.Ticket;

// public interface TicketService {

//     Ticket registerUser2(Ticket user);

//     List<Ticket> getAllUsers2();

//     Ticket getUser2(Long id);

//     String userDelete2(Long id);

//     Ticket userUpdate2(Long id, Ticket user);
// }
package com.example.demo.service;

import com.example.demo.model.Ticket;
import java.util.List;
@Service
public interface TicketService {
    Ticket createTicket(Long userId, Long categoryId, Ticket ticket);
    Ticket getTicket(Long id);
    List<Ticket> getAllTickets();
    List<Ticket> getTicketsByUser(Long userId);
}
