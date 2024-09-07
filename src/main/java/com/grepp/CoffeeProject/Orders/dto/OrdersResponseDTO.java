package com.grepp.CoffeeProject.Orders.dto;

import com.grepp.CoffeeProject.OrderItems.domain.OrderItems;
import com.grepp.CoffeeProject.OrderItems.dto.OrderItemsRequestDTO;
import com.grepp.CoffeeProject.OrderItems.dto.OrderItemsResponseDTO;
import com.grepp.CoffeeProject.Orders.domain.OrderStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrdersResponseDTO {
    public static class OrderDetailDTO {
        private UUID orderId;
        private String email;
        private String address;
        private String postcode;
        private OrderStatus orderStatus;
        private List<OrderItemsResponseDTO.OrderItemsDetailDTO> orderItemsList = new ArrayList<>();


        // 생성자
        public OrderDetailDTO() {}
        public OrderDetailDTO(UUID orderId, String email, String address, String postcode, OrderStatus orderStatus) {
            this.orderId = orderId;
            this.email = email;
            this.address = address;
            this.postcode = postcode;
            this.orderStatus = orderStatus;
        }
        public OrderDetailDTO(UUID orderId, String email, String address, String postcode, OrderStatus orderStatus, List<OrderItemsResponseDTO.OrderItemsDetailDTO> orderItemsList) {
            this.orderId = orderId;
            this.email = email;
            this.address = address;
            this.postcode = postcode;
            this.orderStatus = orderStatus;
            this.orderItemsList = orderItemsList;
        }

        // Getter, Setter
        public UUID getOrderId() {
            return orderId;
        }

        public void setOrderId(UUID orderId) {
            this.orderId = orderId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public OrderStatus getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
        }

        public List<OrderItemsResponseDTO.OrderItemsDetailDTO> getOrderItemsList() {
            return orderItemsList;
        }

        public void setOrderItemsList(List<OrderItemsResponseDTO.OrderItemsDetailDTO> orderItemsList) {
            this.orderItemsList = orderItemsList;
        }


        // toString

        @Override
        public String toString() {
            return "OrderDetailDTO{" +
                    "orderId=" + orderId +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    ", postcode='" + postcode + '\'' +
                    ", orderStatus=" + orderStatus +
                    ", orderItemsList=" + orderItemsList +
                    '}';
        }
    }
}
