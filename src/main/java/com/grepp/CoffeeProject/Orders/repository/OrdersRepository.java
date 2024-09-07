package com.grepp.CoffeeProject.Orders.repository;

import com.grepp.CoffeeProject.Orders.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByEmailOrderByCreatedAtDesc(String email);
}
