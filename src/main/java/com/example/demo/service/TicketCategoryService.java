package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TicketCategoryService;

public interface TicketCategoryService {

    TicketCategoryService registerUser1(TicketCategoryService user);

    List<TicketCategoryService> getAllUsers1();

    TicketCategoryService getUser1(Long id);

    String userDelete1(Long id);

    TicketCategoryService userUpdate1(Long id, TicketCategoryService user);
}
