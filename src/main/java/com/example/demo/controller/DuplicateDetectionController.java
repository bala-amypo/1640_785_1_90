// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.DuplicateDetectionLog;
// import com.example.demo.service.DuplicateDetectionLogService;

// @RestController
// @RequestMapping("/duplicatedetectionlog")
// public class DuplicateDetectionLogController {

//     @Autowired
//     private DuplicateDetectionLogService sev;

//     @PostMapping
//     public DuplicateDetectionLog createUser(@RequestBody DuplicateDetectionLog user) {
//         return sev.registerUser4(user);
//     }

//     @GetMapping
//     public List<DuplicateDetectionLog> getAllUsers() {
//         return sev.getAllUsers4();
//     }

//     @GetMapping("/{id}")
//     public DuplicateDetectionLog getUser(@PathVariable Long id) {
//         return sev.getUser4(id);
//     }

//     @DeleteMapping("/{id}")
//     public String deleteUser(@PathVariable Long id) {
//         return sev.userDelete4(id);
//     }

//     @PutMapping("/{id}")
//     public DuplicateDetectionLog updateUser(@PathVariable Long id,
//                                      @RequestBody DuplicateDetectionLog user) {
//         return sev.userUpdate4(id, user);
//     }
// }
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
