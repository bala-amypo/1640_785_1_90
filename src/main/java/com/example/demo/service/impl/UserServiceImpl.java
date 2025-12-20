package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.UserService;                

@Service
public class UserServiceImpl implements UserService{
    @Autowired UserRepository used;

    
    
    @Override
    public     User registerUser(User user){
        return used.save(use);  
    }
    @Override
     public List<User>getAllData(){
        return used.findAll();
    }
    @Override
    public  String UserDelete(int id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public User getUser(Long id);{
    return used.findById(id).orElse(null);
    }
    @Override
    public User Userupdate(int id,UserService model){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(model);
        } 
        return null;
    }
}