// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.Ticket;

// @Repository
// public interface TicketRepository
//         extends JpaRepository<Ticket, Long> {
// }

public interface TicketRepository {
    Optional<Ticket> findById(Long id);
    List<Ticket> findAll();
    List<Ticket> findByStatus(String status);
    List<Ticket> findByUser_Id(Long userId);
    List<Ticket> findByCategory_Id(Long categoryId);
    List<Ticket> findBySubjectContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String s1, String s2);
    Ticket save(Ticket ticket);
}
