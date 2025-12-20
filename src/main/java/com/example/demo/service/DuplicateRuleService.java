package com.example.demo.service;

import com.example.demo.entity.DuplicateRuleService;
import java.util.List;
public interface DuplicateRuleService{

    DuplicateRuleService postData3(DuplicateRuleService stu);
    List<DuplicateRuleService>getAllData3();
    String DeleteData3(int id);
    DuplicateRuleService getData3(int id);
    DuplicateRuleService updateData3(int id,DuplicateRuleService entity);
}