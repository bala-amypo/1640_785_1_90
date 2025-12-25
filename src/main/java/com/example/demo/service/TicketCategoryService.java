// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.TicketCategory;

// public interface TicketCategoryService {

//     TicketCategory registerUser1(TicketCategory user);

//     List<TicketCategory> getAllUsers1();

//     TicketCategory getUser1(Long id);

//     String userDelete1(Long id);

//     TicketCategory userUpdate1(Long id, TicketCategory user);
// }
package com.example.demo.service;

import com.example.demo.model.TicketCategory;
@Service
public interface TicketCategoryService {
    TicketCategory createCategory(TicketCategory category);
    TicketCategory getCategory(Long id);
}
