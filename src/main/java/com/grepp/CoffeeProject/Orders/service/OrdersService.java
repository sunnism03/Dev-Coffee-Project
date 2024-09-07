package com.grepp.CoffeeProject.Orders.service;

import com.grepp.CoffeeProject.OrderItems.domain.OrderItems;
import com.grepp.CoffeeProject.Orders.converter.OrdersConverter;
import com.grepp.CoffeeProject.Orders.domain.OrderStatus;
import com.grepp.CoffeeProject.Orders.domain.Orders;
import com.grepp.CoffeeProject.Orders.dto.OrdersRequestDTO;
import com.grepp.CoffeeProject.Orders.dto.OrdersResponseDTO;
import com.grepp.CoffeeProject.Orders.repository.OrdersRepository;
import com.grepp.CoffeeProject.Products.domain.Products;
import com.grepp.CoffeeProject.Products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public List<OrdersResponseDTO.OrderDetailDTO> getOrderDetail(OrdersRequestDTO.OrderEmailDTO email) {
        List<Orders> ordersList = ordersRepository.findAllByEmailOrderByCreatedAtDesc(email.getEmail());
        List<OrdersResponseDTO.OrderDetailDTO> ordersDetailDTOs = new ArrayList<>();
        for(Orders order : ordersList) {
            OrdersResponseDTO.OrderDetailDTO orderDetailDTO = ordersConverter.toOrderDTO(order);
            ordersDetailDTOs.add(orderDetailDTO);
        }
        return ordersDetailDTOs;
    }

    @Scheduled(cron = "0 0 14 * * ?")
    public void OrderStatusScheduler() {
        LocalDateTime start = LocalDate.now().minusDays(1).atTime(14, 0, 0);
        LocalDateTime end = LocalDate.now().atTime(13, 59, 59);
        List<Orders> shippingOrders = ordersRepository.findByCreatedAtBetween(start, end);

        for(Orders shippingOrder : shippingOrders) {
            shippingOrder.setOrderStatus(OrderStatus.SHIPPING);
            ordersRepository.save(shippingOrder);
        }
    }
}
