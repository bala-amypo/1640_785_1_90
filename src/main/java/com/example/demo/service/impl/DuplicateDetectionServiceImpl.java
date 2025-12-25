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
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;

import java.util.*;

public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepo;
    private final DuplicateRuleRepository ruleRepo;
    private final DuplicateDetectionLogRepository logRepo;

    public DuplicateDetectionServiceImpl(
            TicketRepository t,
            DuplicateRuleRepository r,
            DuplicateDetectionLogRepository l) {
        this.ticketRepo = t;
        this.ruleRepo = r;
        this.logRepo = l;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {
        Ticket base = ticketRepo.findById(ticketId).orElseThrow();
        List<DuplicateRule> rules = ruleRepo.findAll();
        List<Ticket> open = ticketRepo.findByStatus("OPEN");

        List<DuplicateDetectionLog> result = new ArrayList<>();

        for (Ticket other : open) {
            if (other.getId().equals(base.getId())) continue;

            for (DuplicateRule rule : rules) {
                double score = TextSimilarityUtil.similarity(
                        base.getSubject() + " " + base.getDescription(),
                        other.getSubject() + " " + other.getDescription());

                if (score >= rule.getThreshold()) {
                    DuplicateDetectionLog log =
                            new DuplicateDetectionLog(base, other, score);
                    logRepo.save(log);
                    result.add(log);
                }
            }
        }
        return result;
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepo.findByTicket_Id(ticketId);
    }
}
