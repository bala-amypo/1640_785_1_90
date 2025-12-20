package com.example.demo.service;

import com.example.demo.entity.DuplicateRuleService;
import java.util.List;
public interface DuplicateRuleService{

    DuplicateRuleService postData(DuplicateRuleService stu);
    List<DuplicateRuleService>getAllData();
    String DeleteData(int id);
    DuplicateRuleService getData(int id);
    DuplicateRuleService updateData(int id,DuplicateRuleService entity);
}