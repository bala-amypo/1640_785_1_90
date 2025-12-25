// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.TicketCategory;
// import com.example.demo.repository.TicketCategoryRepository;
// import com.example.demo.service.TicketCategoryService;

// @Service
// public class TicketCategoryServiceImpl implements TicketCategoryService {

//     @Autowired
//     private TicketCategoryRepository used;

//     @Override
//     public TicketCategory registerUser1(TicketCategory user) {
//         return used.save(user);
//     }

//     @Override
//     public List<TicketCategory> getAllUsers1() {
//         return used.findAll();
//     }

//     @Override
//     public String userDelete1(Long id) {
//         used.deleteById(id);
//         return "Deleted successfully";
//     }

//     @Override
//     public TicketCategory getUser1(Long id) {
//         return used.findById(id).orElse(null);
//     }

//     @Override
//     public TicketCategory userUpdate1(Long id, TicketCategory user) {
//         if (used.existsById(id)) {
//             user.setId(id);
//             return used.save(user);
//         }
//         return null;
//     }
// }

