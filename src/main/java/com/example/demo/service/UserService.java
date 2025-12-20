package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
public interface UserService{

    User registerUser(User user);
        User getUser(Long id);
        List<User>getAllData();

    String UserDelete(Long id);
    
    User Userupdate(Long id,User model);
}