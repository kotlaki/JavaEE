package ru.geekbrains.persist;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, updatable = true)
    private String name;

    @Column(name = "description", length = 4096, nullable = false, updatable = true)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "category")
    private List<Products> productsList;

    public Category() {
    }

    public Category(Long id, String name, String description, List<Products> productsList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productsList = productsList;
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

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

//    @Override
//    public String toString() {
//        return String.valueOf(id);
//    }

}
