package ru.geekbrains.service;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;


// клас Data Transfer Object(DTO)
public class ProductDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    @ManyToOne
    private Long categoryId;

    private String categoryName;

    private String categoryDescription;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, BigDecimal price, Long categoryId, String categoryName, String categoryDescription) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
