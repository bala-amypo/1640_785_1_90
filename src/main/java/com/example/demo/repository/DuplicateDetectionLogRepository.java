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
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DuplicateDetectionLogRepository extends JpaRepository<DuplicateDetectionLog, Long> {
    List<DuplicateDetectionLog> findByTicket_Id(Long ticketId);
}
