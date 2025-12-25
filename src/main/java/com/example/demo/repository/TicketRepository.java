// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.Ticket;

// @Repository
// public interface TicketRepository
//         extends JpaRepository<Ticket, Long> {
// }

package com.example.demo.repository;

import com.example.demo.model.Ticket;
import java.util.List;
import java.util.Optional;

public interface TicketRepository {

    Optional<Ticket> findById(Long id);

    List<Ticket> findAll();

    List<Ticket> findByStatus(String status);

    List<Ticket> findByUser_Id(Long userId);

    Ticket save(Ticket ticket);
}
