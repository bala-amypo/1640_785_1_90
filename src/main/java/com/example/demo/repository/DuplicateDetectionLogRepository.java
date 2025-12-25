// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.DuplicateDetectionLog;

// @Repository
// public interface DuplicateDetectionLogRepository
//         extends JpaRepository<DuplicateDetectionLog, Long> {
// }

package com.example.demo.repository;

import com.example.demo.model.DuplicateDetectionLog;
import java.util.List;

public interface DuplicateDetectionLogRepository {

    DuplicateDetectionLog save(DuplicateDetectionLog log);

    List<DuplicateDetectionLog> findByTicket_Id(Long ticketId);
}
