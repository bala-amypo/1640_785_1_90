// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.DuplicateRule;

// public interface DuplicateRuleService {

//     DuplicateRule registerUser3(DuplicateRule user);

//     List<DuplicateRule> getAllUsers3();

//     DuplicateRule getUser3(Long id);

//     String userDelete3(Long id);

//     DuplicateRule userUpdate3(Long id,DuplicateRule user);
// }package com.example.demo.service;
// package com.example.demo.service;

// import com.example.demo.model.DuplicateRule;

// public interface DuplicateRuleService {
//     DuplicateRule createRule(DuplicateRule rule);
//     DuplicateRule getRule(Long id);
// }

package com.example.demo.service;

import com.example.demo.model.DuplicateRule;
import org.springframework.stereotype.Service;

@Service  // This makes it a Spring-managed bean
public class DuplicateRuleServiceImpl implements DuplicateRuleService {
    
    @Override
    public DuplicateRule createRule(DuplicateRule rule) {
        // Add your logic here (e.g., save to repository)
        return rule;
    }
    
    @Override
    public DuplicateRule getRule(Long id) {
        // Add your logic here
        return null;
    }
}

