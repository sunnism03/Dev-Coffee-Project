package com.grepp.CoffeeProject.Products.domain;

import com.grepp.CoffeeProject.OrderItems.domain.OrderItems;
import com.grepp.CoffeeProject.global.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="products")
public class Products extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", columnDefinition = "BINARY(16)")
    private UUID productId;
    @Column(name = "product_name", nullable = false, columnDefinition = "VARCHAR(20)")
    private String productName;
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = true, columnDefinition = "VARCHAR(500) DEFAULT NULL")
    private String description;
    @Column(nullable = false)
    private int stock;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<OrderItems> orderItemsList = new ArrayList<>();


    // 생성자
    public Products() {}
    public Products(UUID productId, String productName, Category category, Long price, String description, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public UUID getProductId() {
        return productId;
    }


    // Getter, Setter
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


    //toString
    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                '}';
    }
}
