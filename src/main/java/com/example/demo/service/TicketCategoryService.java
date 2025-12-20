package com.example.demo.service;

import com.example.demo.model.TicketCategoryService;
import java.util.List;
public interface TicketCategoryService{

    TicketCategoryService postData2(TicketCategoryService stu);
    List<TicketCategoryService>getAllData2();
    String DeleteData2(int id);
    TicketCategoryService getData2(int id);
    TicketCategoryService updateData2(int id,TicketCategoryService model);
}