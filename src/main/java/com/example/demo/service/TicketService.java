import java.util.List;

public interface TicketService {

    Ticket createTicket(Long userId, Long categoryId, Ticket ticket);

    Ticket getTicket(Long ticketId);

    List<Ticket> getTicketsByUser(Long userId);

    List<Ticket> getAllTickets();
     
     String ticketDelete(Long id);

    User ticketUpdate(Long id, Ticket ticket);
}
