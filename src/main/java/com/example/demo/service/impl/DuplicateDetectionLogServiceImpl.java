package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionLogService;

@Service
public class DuplicateDetectionLogServiceImpl implements DuplicateDetectionLogService {

    @Autowired
    private DuplicateDetectionLogRepository used;

    @Override
    public DuplicateDetectionLog registerUser4(DuplicateDetectionLog user) {
        return used.save(user);
    }

    @Override
    public List<DuplicateDetectionLog> getAllUsers4() {
        return used.findAll();
    }

    @Override
    public String userDelete4(Long id) {
        used.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public DuplicateDetectionLog getUser4(Long id) {
        return used.findById(id).orElse(null);
    }

    @Override
    public DuplicateDetectionLog userUpdate4(Long id, DuplicateDetectionLog user) {
        if (used.existsById(id)) {
            user.setId(id);
            return used.save(user);
        }
        return null;
    }
}

