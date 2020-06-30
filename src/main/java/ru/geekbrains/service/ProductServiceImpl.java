package ru.geekbrains.service;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.persist.Products;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

// этот клас для связи представлений Product и Category

@Stateless
public class ProductServiceImpl implements ProductServiceLocal {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void insert(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId());
        productRepository.insert(new Products(null, productDTO.getDescription(), productDTO.getName(),
                productDTO.getPrice(), category));
    }

    @Override
    @Transactional
    public void update(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId());
        productRepository.update(new Products(productDTO.getId(), productDTO.getDescription(), productDTO.getName(),
                productDTO.getPrice(), category));
    }

    @Override
    @Transactional
    public void delete(long id) throws SQLException {
        productRepository.delete(id);
    }

    @Override
    public ProductDTO findById(long id) {
        return productRepository.findProductDTOById(id);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAllProductDTO();
    }

//    @Override
//    @Transactional
//    public List<ProductDTO> findAllProductDTOByCategory(long categoryId) {
//        return productRepository.findAllProductDTOByCategory(categoryId);
//    }

}
