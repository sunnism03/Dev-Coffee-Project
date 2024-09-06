package com.grepp.CoffeeProject.Products.controller;

import com.grepp.CoffeeProject.Products.dto.ProductsResponseDTO;
import com.grepp.CoffeeProject.Products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/{productId}")
    public ProductsResponseDTO.ProductsDetailDTO getProductDetail(@PathVariable UUID productId) {
        return productsService.getProductDetail(productId);
    }

    @GetMapping("/list")
    public List<ProductsResponseDTO.ProductsListDTO> list(){
        List<ProductsResponseDTO.ProductsListDTO> productDTOList = productsService.getProductsDTOList();
        return productDTOList;
    }

}
