// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.TicketCategory;

// @Repository
// public interface TicketCategoryRepository
//         extends JpaRepository<TicketCategory, Long> {
// }
package com.example.demo.repository;

import com.example.demo.model.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {
    boolean existsByCategoryName(String categoryName);
}
