package ru.geekbrains.service;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.persist.Products;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class CategoryService implements CategoryServiceLocal{

    @Inject
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void insert(CategoryDTO category) {
        categoryRepository.insert(new Category(null, category.getName(), category.getDescription()));
    }

    @Override
    @Transactional
    public void update(CategoryDTO category) {
        categoryRepository.update(new Category(category.getId(), category.getName(), category.getDescription()));
    }

    @Override
    @Transactional
    public void delete(long id) throws SQLException {
        categoryRepository.delete(id);
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
