package com.grepp.CoffeeProject.Orders.controller;

import com.grepp.CoffeeProject.Orders.dto.OrdersRequestDTO;
import com.grepp.CoffeeProject.Orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/post")
    public void createOrder(@RequestBody OrdersRequestDTO.OrderDTO request){
        ordersService.createOrder(request);
    }


}
