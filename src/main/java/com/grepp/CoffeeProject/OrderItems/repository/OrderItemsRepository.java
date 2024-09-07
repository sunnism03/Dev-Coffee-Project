package com.grepp.CoffeeProject.OrderItems.repository;

import com.grepp.CoffeeProject.OrderItems.domain.OrderItems;
import com.grepp.CoffeeProject.Orders.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    void deleteByOrders(Orders order);
}
