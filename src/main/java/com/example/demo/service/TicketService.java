package com.example.demo.service;

import com.example.demo.model.TicketService;
import java.util.List;
public interface TicketService{

  TicketService postData1(TicketService stu);
    List<TicketService>getAllData1();
    String DeleteData1(int id);
   TicketService getData1(int id);
   TicketService updateData1(int id,TicketService model);
}