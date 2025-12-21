package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Ticket;

public interface TicketService {

    TicketCategory registerUser2(Ticket user);

    List<Ticket> getAllUsers2();

    Ticket getUser2(Long id);

    String userDelete2(Long id);

    Ticket userUpdate2(Long id, Ticket user);
}
