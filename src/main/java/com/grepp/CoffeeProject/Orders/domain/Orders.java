package com.grepp.CoffeeProject.Orders.domain;

import com.grepp.CoffeeProject.OrderItems.domain.OrderItems;
import com.grepp.CoffeeProject.global.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="orders")
public class Orders extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", columnDefinition = "BINARY(16)")
    private UUID orderId;
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String address;
    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String postcode;
    @Column(name = "order_status", nullable = false, columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderItems> orderItemsList = new ArrayList<>();

    // 생성자
    public Orders() {}
    public Orders(UUID orderId, String email, String address, String postcode, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.orderStatus = orderStatus;
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


    // toString

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
