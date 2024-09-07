package com.grepp.CoffeeProject.Orders.repository;

import com.grepp.CoffeeProject.Orders.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, UUID> {
    Orders findByOrderId(UUID orderId);
    List<Orders> findAllByEmailOrderByCreatedAtDesc(String email);
    List<Orders> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}
