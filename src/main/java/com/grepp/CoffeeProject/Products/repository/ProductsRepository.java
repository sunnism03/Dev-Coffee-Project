package com.grepp.CoffeeProject.Products.repository;

import com.grepp.CoffeeProject.Products.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Products, UUID> {
    Products findByProductId(UUID productId);
}
