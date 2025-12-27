

package com.example.demo.service.impl;

import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;  // Add this import

@Service 
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository ruleRepository;

    public DuplicateRuleServiceImpl(DuplicateRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override  // ← ADD THESE for clarity
    public DuplicateRule createRule(DuplicateRule rule) {
        ruleRepository.findByRuleName(rule.getRuleName())
                .ifPresent(r -> { throw new RuntimeException("Rule already exists"); });
        return ruleRepository.save(rule);
    }

    @Override
    public DuplicateRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }
}
