package com.grepp.CoffeeProject.Orders.service;

import com.grepp.CoffeeProject.Orders.converter.OrdersConverter;
import com.grepp.CoffeeProject.Orders.domain.Orders;
import com.grepp.CoffeeProject.Orders.dto.OrdersRequestDTO;
import com.grepp.CoffeeProject.Orders.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired
    private OrdersConverter ordersConverter;

    @Autowired
    private OrdersRepository ordersRepository;
    public void createOrder(OrdersRequestDTO.OrderDTO orderDTO){
        Orders order = ordersConverter.toOrdersEntity(orderDTO);
        ordersRepository.save(order);
    }
}
