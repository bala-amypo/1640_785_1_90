// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.TicketCategory;

// @Repository
// public interface TicketCategoryRepository
//         extends JpaRepository<TicketCategory, Long> {
// }

public interface TicketCategoryRepository {
    Optional<TicketCategory> findById(Long id);
    boolean existsByCategoryName(String name);
    TicketCategory save(TicketCategory category);
}
