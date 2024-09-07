package com.grepp.CoffeeProject.OrderItems.dto;

import com.grepp.CoffeeProject.Products.domain.Category;

import java.util.UUID;

public class OrderItemsRequestDTO {
    public static class OrderItemsDTO {
        private UUID productId;
        private int quantity;
        private Category category;

        // 생성자
        public OrderItemsDTO() {}
        public OrderItemsDTO(UUID productId, int quantity, Category category) {
            this.productId = productId;
            this.quantity = quantity;
            this.category = category;
        }

        // Getter, Setter

        public UUID getProductId() {
            return productId;
        }

        public void setProductId(UUID productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }


        // toString
        @Override
        public String toString() {
            return "OrderItemsDTO{" +
                    ", productId=" + productId +
                    ", quantity=" + quantity +
                    ", category=" + category +
                    '}';
        }
    }
}
