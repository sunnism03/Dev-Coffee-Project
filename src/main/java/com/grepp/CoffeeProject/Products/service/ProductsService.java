package com.grepp.CoffeeProject.Products.service;

import com.grepp.CoffeeProject.Products.converter.ProductsConverter;
import com.grepp.CoffeeProject.Products.domain.Products;
import com.grepp.CoffeeProject.Products.dto.ProductsResponseDTO;
import com.grepp.CoffeeProject.Products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductsService {
    @Autowired
    private ProductsConverter productsConverter;
    @Autowired
    private ProductsRepository productsRepository;

    @Transactional
    public ProductsResponseDTO.ProductsDetailDTO getProductDetail(UUID productId) {
        ProductsResponseDTO.ProductsDetailDTO productDetailDTO = productsConverter.toProductDetailDTO(productsRepository.findByProductId(productId));
        return productDetailDTO;
    }

    @Transactional
    public List<ProductsResponseDTO.ProductsListDTO> getProductsDTOList() {
        List<Products> products = productsRepository.findAll();
        List<ProductsResponseDTO.ProductsListDTO> productsDTOs = productsConverter.toProductsDTOs(products);
        return productsDTOs;
    }
}
