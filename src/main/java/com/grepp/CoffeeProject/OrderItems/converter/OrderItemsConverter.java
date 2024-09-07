package com.grepp.CoffeeProject.OrderItems.converter;

import com.grepp.CoffeeProject.OrderItems.domain.OrderItems;
import com.grepp.CoffeeProject.OrderItems.dto.OrderItemsRequestDTO;
import com.grepp.CoffeeProject.Products.domain.Products;
import com.grepp.CoffeeProject.Products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class OrderItemsConverter {
    @Autowired
    private ProductsRepository productsRepository;

    public List<OrderItems> toOrderItemsList(List<OrderItemsRequestDTO.OrderItemsDTO> orderItemsDTOs) {
        List<OrderItems> orderItemsList = new ArrayList<>();
        for (OrderItemsRequestDTO.OrderItemsDTO orderItemsDTO : orderItemsDTOs) {
            UUID productId = orderItemsDTO.getProductId();
            Products product = productsRepository.findByProductId(productId);
            Long productPrice = product.getPrice();

            OrderItems orderItem = new OrderItems(orderItemsDTO.getCategory(), productPrice, orderItemsDTO.getQuantity(), product);

            orderItemsList.add(orderItem);
        }
        return orderItemsList;
    }
}
