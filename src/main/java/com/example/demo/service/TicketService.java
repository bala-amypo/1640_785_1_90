package com.example.demo.service;

import com.example.demo.entity.TicketService;
import java.util.List;
public interface TicketService{

  TicketService postData(TicketService stu);
    List<TicketService>getAllData();
    String DeleteData(int id);
    UserService getData(int id);
    UserService updateData(int id,UserService entity);
}