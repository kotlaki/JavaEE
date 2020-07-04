package ru.geekbrains.service;

import ru.geekbrains.persist.Products;

import java.math.BigDecimal;

public class ProductServiceWs {
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    public ProductServiceWs() {
    }

    public ProductServiceWs(ProductDTO products) {
        this.id = products.getId();
        this.name = products.getName();
        this.description = products.getDescription();
        this.price = products.getPrice();
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
