
package com.example.demo.controller;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duplicates")
public class DuplicateDetectionController {

    private final DuplicateDetectionService detectionService;

    public DuplicateDetectionController(DuplicateDetectionService detectionService) {
        this.detectionService = detectionService;
    }

    @PostMapping("/{ticketId}")
    public List<DuplicateDetectionLog> detectDuplicates(@PathVariable Long ticketId) {
        return detectionService.detectDuplicates(ticketId);
    }

    @GetMapping("/logs/{ticketId}")
    public List<DuplicateDetectionLog> getLogs(@PathVariable Long ticketId) {
        return detectionService.getLogsForTicket(ticketId);
    }
}
