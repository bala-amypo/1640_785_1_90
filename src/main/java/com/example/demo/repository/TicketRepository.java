package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Ticket;
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByUser(Ticket ticket);
}
