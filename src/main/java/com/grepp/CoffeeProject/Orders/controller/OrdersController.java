package com.grepp.CoffeeProject.Orders.controller;

import com.grepp.CoffeeProject.Orders.dto.OrdersRequestDTO;
import com.grepp.CoffeeProject.Orders.dto.OrdersResponseDTO;
import com.grepp.CoffeeProject.Orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/post")
    public void createOrder(@RequestBody OrdersRequestDTO.OrderDTO request){
        ordersService.createOrder(request);
    }

    @GetMapping("/get")
    public List<OrdersResponseDTO.OrderDetailDTO> getOrderDetail(@RequestBody OrdersRequestDTO.OrderEmailDTO request) {
        return ordersService.getOrderDetail(request);
    }

    @PutMapping("/update")
    public void updateOrder(@RequestParam UUID orderId, @RequestBody OrdersRequestDTO.OrderDTO updateDTO) {
        ordersService.updateOrder(orderId, updateDTO);
    }
}
