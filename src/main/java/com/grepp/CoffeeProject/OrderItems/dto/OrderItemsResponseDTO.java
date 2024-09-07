package com.grepp.CoffeeProject.OrderItems.dto;

import com.grepp.CoffeeProject.Products.domain.Category;

import java.util.UUID;

public class OrderItemsResponseDTO {
    public static class OrderItemsDetailDTO {
        private Long seq;
        private UUID orderId;
        private UUID productId;
        private Long price;
        private int quantity;
        private Category category;


        // 생성자
        public OrderItemsDetailDTO() {}

        public OrderItemsDetailDTO(Long seq, UUID orderId, UUID productId, Long price, int quantity, Category category) {
            this.seq = seq;
            this.orderId = orderId;
            this.productId = productId;
            this.price = price;
            this.quantity = quantity;
            this.category = category;
        }


        // Getter, Setter
        public Long getSeq() {
            return seq;
        }

        public void setSeq(Long seq) {
            this.seq = seq;
        }

        public UUID getOrderId() {
            return orderId;
        }

        public void setOrderId(UUID orderId) {
            this.orderId = orderId;
        }

        public UUID getProductId() {
            return productId;
        }

        public void setProductId(UUID productId) {
            this.productId = productId;
        }

        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
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
            return "OrderItemsDetailDTO{" +
                    "seq=" + seq +
                    ", orderId=" + orderId +
                    ", productId=" + productId +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", category=" + category +
                    '}';
        }
    }
}
