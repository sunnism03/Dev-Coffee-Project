package com.grepp.CoffeeProject.Orders.service;

import com.grepp.CoffeeProject.OrderItems.domain.OrderItems;
import com.grepp.CoffeeProject.Orders.converter.OrdersConverter;
import com.grepp.CoffeeProject.Orders.domain.Orders;
import com.grepp.CoffeeProject.Orders.dto.OrdersRequestDTO;
import com.grepp.CoffeeProject.Orders.repository.OrdersRepository;
import com.grepp.CoffeeProject.Products.domain.Products;
import com.grepp.CoffeeProject.Products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrdersService {

    @Autowired
    private OrdersConverter ordersConverter;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductsRepository productsRepository;

    public void createOrder(OrdersRequestDTO.OrderDTO orderDTO){
        Orders order = ordersConverter.toOrdersEntity(orderDTO);
        ordersRepository.save(order);

        List<OrderItems> orderItemsList = order.getOrderItemsList();
        for(OrderItems orderItem : orderItemsList) {
            UUID productId = orderItem.getProducts().getProductId();
            int productsNum = orderItem.getQuantity();
            Products product = productsRepository.findByProductId(productId);
            product.setStock(product.getStock() - productsNum);
            productsRepository.save(product);
        }
    }
}
