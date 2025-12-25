// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.DuplicateDetectionLog;

// public interface DuplicateDetectionLogService {

//     DuplicateDetectionLog registerUser4(DuplicateDetectionLog user);

//     List<DuplicateDetectionLog> getAllUsers4();

//     DuplicateDetectionLog getUser4(Long id);

//     String userDelete4(Long id);

//     DuplicateDetectionLog userUpdate4(Long id,DuplicateDetectionLog user);
// }
package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;
import java.util.List;
@Service
public interface DuplicateDetectionService {
    List<DuplicateDetectionLog> detectDuplicates(Long ticketId);
    List<DuplicateDetectionLog> getLogsForTicket(Long ticketId);
}
