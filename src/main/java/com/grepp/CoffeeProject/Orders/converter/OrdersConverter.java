package com.grepp.CoffeeProject.Orders.converter;

import com.grepp.CoffeeProject.OrderItems.converter.OrderItemsConverter;
import com.grepp.CoffeeProject.OrderItems.domain.OrderItems;
import com.grepp.CoffeeProject.OrderItems.dto.OrderItemsResponseDTO;
import com.grepp.CoffeeProject.Orders.domain.Orders;
import com.grepp.CoffeeProject.Orders.dto.OrdersRequestDTO;
import com.grepp.CoffeeProject.Orders.dto.OrdersResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class OrdersConverter {

    @Autowired
    private OrderItemsConverter orderItemsConverter;
    public Orders toOrdersEntity(OrdersRequestDTO.OrderDTO orderDTO) {
        Orders order = new Orders(orderDTO.getEmail(), orderDTO.getAddress(), orderDTO.getPostcode());
        // orderItem 넣어야 됨
        List<OrderItems> orderItemsList = orderItemsConverter.toOrderItemsList(orderDTO.getOrderItemsDTOs());
        for(OrderItems orderItem : orderItemsList){
            orderItem.setOrders(order);
        }

        order.setOrderItemsList(orderItemsList);
        return order;
    }

    public OrdersResponseDTO.OrderDetailDTO toOrderDTO(Orders order){
        OrdersResponseDTO.OrderDetailDTO orderDTO = new OrdersResponseDTO.OrderDetailDTO(order.getOrderId(), order.getEmail(), order.getAddress(), order.getPostcode(), order.getOrderStatus());
        List<OrderItemsResponseDTO.OrderItemsDetailDTO> orderItemsDetailDTOs = orderItemsConverter.toOrderItemsDTOs(order.getOrderItemsList());
        orderDTO.setOrderItemsList(orderItemsDetailDTOs);
        return orderDTO;
    }
}
