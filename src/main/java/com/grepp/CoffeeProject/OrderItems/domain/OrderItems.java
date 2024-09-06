package com.grepp.CoffeeProject.OrderItems.domain;


import com.grepp.CoffeeProject.Orders.domain.Orders;
import com.grepp.CoffeeProject.Products.domain.Category;
import com.grepp.CoffeeProject.Products.domain.Products;
import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Products products;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders orders;

    // 생성자
    public OrderItems() {}
    public OrderItems(Long seq, Category category, Long price, int quantity, Products products, Orders orders) {
        this.seq = seq;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.products = products;
        this.orders = orders;
    }

    // Getter, Setter
    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    // toString
    @Override
    public String toString() {
        return "OrderItems{" +
                "seq=" + seq +
                ", category=" + category +
                ", price=" + price +
                ", quantity=" + quantity +
                ", products=" + products +
                ", orders=" + orders +
                '}';
    }
}
