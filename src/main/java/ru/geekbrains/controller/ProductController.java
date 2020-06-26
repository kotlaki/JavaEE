package ru.geekbrains.controller;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.persist.Products;
import ru.geekbrains.service.ProductDTO;
import ru.geekbrains.service.ProductService;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class ProductController  implements Serializable {

    @Inject
    private ProductService productService;

    @Inject
    private CategoryRepository categoryRepository;

    private ProductDTO productDTO;

    private List<ProductDTO> productDTOList;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    // метод выводит список товаров из БД при открытии каталога
    public void preloadProducts(ComponentSystemEvent componentSystemEvent) {
        this.productDTOList = productService.findAll();
    }

    public String createProduct() {
        this.productDTO = new ProductDTO();
        return "/product.xhtml?faces-redirect=true";
    }

    public List<ProductDTO> getAllProducts() {
        return productDTOList;
    }

    public String editProduct(ProductDTO productDTO) {
        this.productDTO = productDTO;
        return "/product.xhtml?faces-redirect=true";
    }

    public String deleteProduct(ProductDTO productDTO) throws SQLException {
        productService.delete(productDTO.getId());
        return "/catalog.xhtml?faces-redirect=true";
    }

    public String saveProduct() {
        if(productDTO.getId() == null) {
            productService.insert(productDTO);
        } else {
            productService.update(productDTO);
        }
        return "/catalog.xhtml?faces-redirect=true";
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
