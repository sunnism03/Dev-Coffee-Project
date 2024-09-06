package com.grepp.CoffeeProject.Products.dto;

import com.grepp.CoffeeProject.Products.domain.Category;
import com.grepp.CoffeeProject.Products.domain.Products;

import java.util.UUID;

public class ProductsResponseDTO {
    public static class ProductsListDTO {
        private UUID productId;
        private String productName;
        private Category category;

        // 생성자
        public ProductsListDTO() {}

        public ProductsListDTO(UUID productId, String productName, Category category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }


        // Getter, Setter
        public UUID getProductId() {
            return productId;
        }

        public void setProductId(UUID productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
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
            return "ProductsListDTO{" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", category=" + category +
                    '}';
        }
    }

    public static class ProductsDetailDTO {
        private UUID productId;
        private String productName;
        private Category category;
        private Long price;
        private String description;
        private int stock;

        // 생성자
        public ProductsDetailDTO() {}

        public ProductsDetailDTO(UUID productId, String productName, Category category, Long price, String description, int stock) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
            this.price = price;
            this.description = description;
            this.stock = stock;
        }

        // Getter, Setter
        public UUID getProductId() {
            return productId;
        }

        public void setProductId(UUID productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }


        // toString
        @Override
        public String toString() {
            return "ProductsDetailDTO{" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", category=" + category +
                    ", price=" + price +
                    ", description='" + description + '\'' +
                    ", stock=" + stock +
                    '}';
        }
    }
}
