package com.example.demo.service;

import com.example.demo.model.TicketCategory;
import java.util.List;

public interface TicketCategoryService {

    List<TicketCategory> getAll();

    TicketCategory getById(Long id);

    TicketCategory create(TicketCategory category);

    TicketCategory update(Long id, TicketCategory category);

    void delete(Long id);
}
