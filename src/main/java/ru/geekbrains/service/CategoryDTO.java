package ru.geekbrains.service;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

public class CategoryDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    @OneToMany
    private Long productId;

    private String productName;

    private String productDescription;

    private BigDecimal productPrice;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name, String description, Long productId, String productName, String productDescription, BigDecimal productPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
