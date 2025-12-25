// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.DuplicateRule;

// @Repository
// public interface DuplicateRuleRepository
//         extends JpaRepository<DuplicateRule, Long> {
// }

package com.example.demo.repository;

import com.example.demo.model.DuplicateRule;
import java.util.List;
import java.util.Optional;

public interface DuplicateRuleRepository {

    Optional<DuplicateRule> findById(Long id);

    List<DuplicateRule> findAll();

    DuplicateRule save(DuplicateRule rule);
}

