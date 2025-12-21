package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TicketCategory;

public interface TicketCategoryService {

   TicketCategory registerUser(TicketCategory user);

    List<TicketCategory> getAllUsers();

    TicketCategory getUser(Long id);

    String userDelete(Long id);

    TicketCategory userUpdate(Long id, TicketCategory user);
}
