package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController{
    @Autowired  UserService ser;
    @PostMapping("/register")
    public User sendData1(@RequestBody User stu){
        return ser.registerUser(stu);
    }
    @GetMapping("/all")
    public List<User> getval1(){
        return ser.getAllData1();
    }
    @DeleteMapping("/delete/{id}")
    public String del1(@PathVariable Long id){
        return ser.UserDelete(id);
    }
    @GetMapping("/all/{id}")
    public User find1(@PathVariable Long id){
        return ser.getUser(id);
    }
    @PutMapping("/put/{id}")
    public User putval1(@PathVariable Long id,@RequestBody User entity){
        return ser.Userupdate(id,entity);
    }
}