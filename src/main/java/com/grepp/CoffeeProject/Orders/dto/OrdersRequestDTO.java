package com.grepp.CoffeeProject.Orders.dto;

import com.grepp.CoffeeProject.OrderItems.dto.OrderItemsRequestDTO;
import com.grepp.CoffeeProject.Orders.domain.OrderStatus;

import java.util.List;

public class OrdersRequestDTO {
    public static class OrderDTO {
        private String address;
        private String email;
        private String postcode;
        private List<OrderItemsRequestDTO.OrderItemsDTO> orderItemsDTOs;

        // 생성자
        public OrderDTO() {}
        public OrderDTO(String address, String email, String postcode, List<OrderItemsRequestDTO.OrderItemsDTO> orderItemsDTOs) {
            this.address = address;
            this.email = email;
            this.postcode = postcode;
            this.orderItemsDTOs = orderItemsDTOs;
        }

        // Getter, Setter
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public List<OrderItemsRequestDTO.OrderItemsDTO> getOrderItemsDTOs() {
            return orderItemsDTOs;
        }

        public void setOrderItemsDTOs(List<OrderItemsRequestDTO.OrderItemsDTO> orderItemsDTOs) {
            this.orderItemsDTOs = orderItemsDTOs;
        }


        // toString
        @Override
        public String toString() {
            return "OrderDTO{" +
                    "address='" + address + '\'' +
                    ", email='" + email + '\'' +
                    ", postcode='" + postcode + '\'' +
                    ", orderItemsDTOs=" + orderItemsDTOs +
                    '}';
        }
    }
}
