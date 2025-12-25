// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.DuplicateRule;

// @Repository
// public interface DuplicateRuleRepository
//         extends JpaRepository<DuplicateRule, Long> {
// }

package com.example.demo.service;

import com.example.demo.model.DuplicateRule;

public interface DuplicateRuleService {

    DuplicateRule createRule(DuplicateRule rule);

    DuplicateRule getRule(Long id);
}
