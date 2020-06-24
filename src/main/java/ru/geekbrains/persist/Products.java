package ru.geekbrains.persist;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table (name = "products")
@Entity
public class Products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255, nullable = false, updatable = true)
    private String name;

    @Column(name = "description", length = 4096, nullable = false, updatable = true)
    private String description;

    @Column(name = "price", nullable = false, updatable = true)
    private BigDecimal price;

//    @Column(name = "active", nullable = false, updatable = true)
//    private boolean active;

    @ManyToOne
    private Category category;

    public Products() {
    }

//    public Products(Long id, String name, String description, BigDecimal price) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//    }


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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
