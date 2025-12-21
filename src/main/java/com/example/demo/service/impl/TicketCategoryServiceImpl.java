package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TicketCategory;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TicketCategoryService;

@Service
public class TicketCategoryServiceImpl implements TicketCategoryService {

    @Autowired
    private TicketCategoryRepository used;

    @Override
    public TicketCategoryService registerUser1(TicketCategoryService user) {
        return used.save(user);
    }

    @Override
    public List<TicketCategoryService> getAllUsers1() {
        return used.findAll();
    }

    @Override
    public String userDelete1(Long id) {
        used.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public TicketCategoryService getUser1(Long id) {
        return used.findById(id).orElse(null);
    }

    @Override
    public TicketCategoryService userUpdate1(Long id, TicketCategoryService user) {
        if (used.existsById(id)) {
            user.setId(id);
            return used.save(user);
        }
        return null;
    }
}

