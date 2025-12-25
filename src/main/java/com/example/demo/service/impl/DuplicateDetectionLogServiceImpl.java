// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.DuplicateDetectionLog;
// import com.example.demo.repository.DuplicateDetectionLogRepository;
// import com.example.demo.service.DuplicateDetectionLogService;

// @Service
// public class DuplicateDetectionLogServiceImpl implements DuplicateDetectionLogService {

//     @Autowired
//     private DuplicateDetectionLogRepository used;

//     @Override
//     public DuplicateDetectionLog registerUser4(DuplicateDetectionLog user) {
//         return used.save(user);
//     }

//     @Override
//     public List<DuplicateDetectionLog> getAllUsers4() {
//         return used.findAll();
//     }

//     @Override
//     public String userDelete4(Long id) {
//         used.deleteById(id);
//         return "Deleted successfully";
//     }

//     @Override
//     public DuplicateDetectionLog getUser4(Long id) {
//         return used.findById(id).orElse(null);
//     }

//     @Override
//     public DuplicateDetectionLog userUpdate4(Long id, DuplicateDetectionLog user) {
//         if (used.existsById(id)) {
//             user.setId(id);
//             return used.save(user);
//         }
//         return null;
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DuplicateDetectionLogService;
import com.example.demo.util.TextSimilarityUtil;

import java.util.*;

public class DuplicateDetectionLogServiceImpl implements DuplicateDetectionLogService {

    private final TicketRepository ticketRepo;
    private final DuplicateRuleRepository ruleRepo;
    private final DuplicateDetectionLogRepository logRepo;

    public DuplicateDetectionLogServiceImpl(TicketRepository t, DuplicateRuleRepository r, DuplicateDetectionLogRepository l) {
        this.ticketRepo = t;
        this.ruleRepo = r;
        this.logRepo = l;
    }

    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {
        Ticket base = ticketRepo.findById(ticketId).orElseThrow();
        List<DuplicateRule> rules = ruleRepo.findAll();
        List<Ticket> openTickets = ticketRepo.findByStatus("OPEN");

        List<DuplicateDetectionLog> result = new ArrayList<>();

        for (Ticket other : openTickets) {
            if (other == base) continue;

            for (DuplicateRule rule : rules) {
                double score = 0;

                if ("EXACT_MATCH".equals(rule.getMatchType())) {
                    if (base.getSubject() != null &&
                        base.getSubject().equalsIgnoreCase(other.getSubject())) {
                        score = 1.0;
                    }
                } else {
                    score = TextSimilarityUtil.similarity(
                            String.valueOf(base.getSubject()) + " " + String.valueOf(base.getDescription()),
                            String.valueOf(other.getSubject()) + " " + String.valueOf(other.getDescription()));
                }

                if (score >= rule.getThreshold()) {
                    DuplicateDetectionLog log = new DuplicateDetectionLog(base, other, score);
                    logRepo.save(log);
                    result.add(log);
                }
            }
        }
        return result;
    }

    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepo.findByTicket_Id(ticketId);
    }
}
