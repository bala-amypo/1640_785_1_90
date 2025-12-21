package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface UserService {

    User registerUser1(User user);

    List<User> getAllUsers1();

    User getUser1(Long id);

    String userDelete1(Long id);

    User userUpdate1(Long id, User user);
}
