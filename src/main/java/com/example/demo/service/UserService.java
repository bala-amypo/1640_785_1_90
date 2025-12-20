package com.example.demo.service;

import com.example.demo.entity.studententity;
import java.util.List;
public interface studentservice{

    studententity postData(studententity stu);
    List<studententity>getAllData();
    String DeleteData(int id);
    studententity getData(int id);
    studententity updateData(int id,studententity entity);
}