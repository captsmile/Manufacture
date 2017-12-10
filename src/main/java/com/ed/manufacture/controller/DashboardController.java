package com.ed.manufacture.controller;

import com.ed.manufacture.dao.ViewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @Autowired
    ViewsRepository viewsRepository;

    @GetMapping("/order")
    String getOrder(){
        return viewsRepository.getOrder();
    }


}
