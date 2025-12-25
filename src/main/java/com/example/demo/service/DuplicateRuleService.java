package com.example.demo.service;

import java.util.List;
import com.example.demo.model.DuplicateRule;

public interface DuplicateRuleService {

    DuplicateRule registerUser3(DuplicateRule user);

    List<DuplicateRule> getAllUsers3();

    DuplicateRule getUser3(Long id);

    String userDelete3(Long id);

    DuplicateRule userUpdate3(Long id,DuplicateRule user);
}
package com.example.demo.service;

import com.example.demo.model.DuplicateRule;

public interface DuplicateRuleService {
    DuplicateRule createRule(DuplicateRule rule);
    DuplicateRule getRule(Long id);
}
