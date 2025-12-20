package com.example.demo.service;

import com.example.demo.entity.UserService;
import java.util.List;
public interface UserService{

    user re(UserService stu);
    List<UserService>getAllData();
    String DeleteData(int id);
    UserService getData(int id);
    UserService updateData(int id,UserService entity);
}