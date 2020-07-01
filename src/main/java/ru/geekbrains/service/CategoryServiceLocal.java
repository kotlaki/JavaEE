package ru.geekbrains.service;

import ru.geekbrains.persist.Category;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface CategoryServiceLocal {

    void insert(CategoryDTO category);

    void update(CategoryDTO category);

    void delete(long id) throws SQLException;

    Category findById(long id);

    List<Category> findAll();
}
