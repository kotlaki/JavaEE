package ru.geekbrains.service;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface ProductServiceLocal {
    void insert(ProductDTO productDTO);

    void update(ProductDTO productDTO);

    void delete(long id) throws SQLException;

    ProductDTO findById(long id);

    List<ProductDTO> findAll();

//    List<ProductDTO> findAllProductDTOByCategory(long categoryId);
}
