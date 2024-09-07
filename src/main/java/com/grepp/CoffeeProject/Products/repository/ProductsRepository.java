package com.grepp.CoffeeProject.Products.repository;

import com.grepp.CoffeeProject.Products.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Products, UUID> {
    Products findByProductId(UUID productId);
}
