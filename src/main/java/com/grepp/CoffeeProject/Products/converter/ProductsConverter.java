package com.grepp.CoffeeProject.Products.converter;

import com.grepp.CoffeeProject.Products.domain.Category;
import com.grepp.CoffeeProject.Products.domain.Products;
import com.grepp.CoffeeProject.Products.dto.ProductsResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsConverter {
    public ProductsResponseDTO.ProductsDetailDTO toProductDetailDTO(Products product) {
        return new ProductsResponseDTO.ProductsDetailDTO(product.getProductId(), product.getProductName(), product.getCategory(), product.getPrice(), product.getDescription(), product.getStock());
    }

    public List<ProductsResponseDTO.ProductsListDTO> toProductsDTOs(List<Products> products) {
        List<ProductsResponseDTO.ProductsListDTO> productsDTOs = new ArrayList<>();
        for(Products product : products) {
            ProductsResponseDTO.ProductsListDTO productDTO = new ProductsResponseDTO.ProductsListDTO(product.getProductId(), product.getProductName(), product.getCategory());
            productsDTOs.add(productDTO);
        }
        return productsDTOs;
    }

}
