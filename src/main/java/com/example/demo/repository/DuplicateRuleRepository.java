// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.DuplicateRule;

// @Repository
// public interface DuplicateRuleRepository
//         extends JpaRepository<DuplicateRule, Long> {
// }

public interface DuplicateRuleRepository {
    Optional<DuplicateRule> findById(Long id);
    Optional<DuplicateRule> findByRuleName(String name);
    List<DuplicateRule> findAll();
    DuplicateRule save(DuplicateRule rule);
}
