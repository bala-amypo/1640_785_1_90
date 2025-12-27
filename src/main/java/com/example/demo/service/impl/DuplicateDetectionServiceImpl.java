
package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.DuplicateRule;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service   
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepository;
    private final DuplicateRuleRepository ruleRepository;
    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionServiceImpl(TicketRepository ticketRepository,
                                         DuplicateRuleRepository ruleRepository,
                                         DuplicateDetectionLogRepository logRepository) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {
        Ticket base = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("ticket not found"));

        List<DuplicateRule> rules = ruleRepository.findAll();
        List<Ticket> candidates = ticketRepository.findByStatus("OPEN");

        List<DuplicateDetectionLog> result = new ArrayList<>();
        if (rules.isEmpty() || candidates.isEmpty()) {
            return List.of();
        }

        for (Ticket other : candidates) {
            if (base.getId() != null && other.getId() != null
                    && base.getId().equals(other.getId())) {
                continue;
            }
            for (DuplicateRule rule : rules) {
                double score = 0.0;

                switch (rule.getMatchType()) {
                    case "EXACT_MATCH" -> {
                        String s1 = base.getSubject() == null ? "" : base.getSubject();
                        String s2 = other.getSubject() == null ? "" : other.getSubject();
                        score = s1.equalsIgnoreCase(s2) ? 1.0 : 0.0;
                    }
                    case "KEYWORD" -> {
                        String t1 = ((base.getSubject() == null ? "" : base.getSubject()) + " " +
                                (base.getDescription() == null ? "" : base.getDescription())).trim();
                        String t2 = ((other.getSubject() == null ? "" : other.getSubject()) + " " +
                                (other.getDescription() == null ? "" : other.getDescription())).trim();
                        score = TextSimilarityUtil.similarity(t1, t2);
                    }
                    case "SIMILARITY" -> {
                        String d1 = base.getDescription() == null ? "" : base.getDescription();
                        String d2 = other.getDescription() == null ? "" : other.getDescription();
                        score = TextSimilarityUtil.similarity(d1, d2);
                    }
                    default -> score = 0.0;
                }

                if (score >= rule.getThreshold()) {
                    DuplicateDetectionLog log = new DuplicateDetectionLog(base, other, score);
                    logRepository.save(log);
                    result.add(log);
                }
            }
        }
        return result;
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}
