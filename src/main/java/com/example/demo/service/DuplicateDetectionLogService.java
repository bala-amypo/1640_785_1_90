package com.example.demo.service;

import java.util.List;
import com.example.demo.model.DuplicateDetectionLog;

public interface DuplicateDetectionLogService {

    DuplicateDetectionLog registerUser4(DuplicateDetectionLog user);

    List<DuplicateDetectionLog> getAllUsers4();

    DuplicateDetectionLog getUser4(Long id);

    String userDelete4(Long id);

    DuplicateDetectionLog userUpdate4(Long id,DuplicateDetectionLog user);
}
