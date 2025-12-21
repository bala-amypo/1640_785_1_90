package com.example.demo.service;

import java.util.List;
import com.example.demo.model.DuplicateRule;

public interface DuplicateDetectionLogService {

    DuplicateRule registerUser4(DuplicateRule user);

    List<DuplicateRule> getAllUsers4();

    DuplicateRule getUser4(Long id);

    String userDelete4(Long id);

    DuplicateRule userUpdate4(Long id,DuplicateRule user);
}
