package ru.kurganov;

import java.math.BigDecimal;

public class Products {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;

    public Products() {
    }

    public Products(long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
