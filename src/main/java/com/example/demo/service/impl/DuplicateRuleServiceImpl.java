// // package com.example.demo.service.impl;

// // import java.util.List;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.stereotype.Service;

// // import com.example.demo.model.DuplicateRule;
// // import com.example.demo.repository.DuplicateRuleRepository;
// // import com.example.demo.service.DuplicateRuleService;

// // @Service
// // public class DuplicateRuleServiceImpl implements DuplicateRuleService {

// //     @Autowired
// //     private DuplicateRuleRepository used;

// //     @Override
// //     public DuplicateRule registerUser3(DuplicateRule user) {
// //         return used.save(user);
// //     }

// //     @Override
// //     public List<DuplicateRule> getAllUsers3() {
// //         return used.findAll();
// //     }

// //     @Override
// //     public String userDelete3(Long id) {
// //         used.deleteById(id);
// //         return "Deleted successfully";
// //     }

// //     @Override
// //     public DuplicateRule getUser3(Long id) {
// //         return used.findById(id).orElse(null);
// //     }

// //     @Override
// //     public DuplicateRule userUpdate3(Long id, DuplicateRule user) {
// //         if (used.existsById(id)) {
// //             user.setId(id);
// //             return used.save(user);
// //         }
// //         return null;
// //     }
// // }
// package com.example.demo.service.impl;

// import com.example.demo.model.DuplicateRule;
// import com.example.demo.repository.DuplicateRuleRepository;
// import com.example.demo.service.DuplicateRuleService;

// public class DuplicateRuleServiceImpl implements DuplicateRuleService {

//     private final DuplicateRuleRepository ruleRepository;

//     public DuplicateRuleServiceImpl(DuplicateRuleRepository ruleRepository) {
//         this.ruleRepository = ruleRepository;
//     }

//     @Override
//     public DuplicateRule createRule(DuplicateRule rule) {
//         ruleRepository.findByRuleName(rule.getRuleName())
//                 .ifPresent(r -> { throw new RuntimeException("exists"); });
//         return ruleRepository.save(rule);
//     }

//     @Override
//     public DuplicateRule getRule(Long id) {
//         return ruleRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("rule not found"));
//     }
// }
// File: src/main/java/com/example/demo/service/impl/DuplicateRuleServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.model.DuplicateRule;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    @Override
    public DuplicateRule createRule(DuplicateRule rule) {
        // your logic
        return rule;
    }

    @Override
    public DuplicateRule getRule(Long id) {
        // your logic
        return null;
    }
}