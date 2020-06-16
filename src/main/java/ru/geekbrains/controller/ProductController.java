package ru.geekbrains.controller;

import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.persist.Products;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class ProductController  implements Serializable {

    @Inject
    private ProductRepository productRepository;

    private Products products;

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String createProduct() {
        this.products = new Products();
        return "/product.xhtml?faces-redirect=true";
    }

    public List<Products> getAllProducts() throws SQLException {
        return productRepository.findAll();
    }

    public String editProduct(Products product) {
        this.products = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public String deleteProduct(Products product) throws SQLException {
        productRepository.delete(product.getId());
        return "/index.xhtml?faces-redirect=true";
    }

    public String saveProduct() throws SQLException {
        if(products.getId() == null) {
            productRepository.insert(products);
        } else {
            productRepository.update(products);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}
