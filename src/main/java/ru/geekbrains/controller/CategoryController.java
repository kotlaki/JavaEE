package ru.geekbrains.controller;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.persist.Products;
import ru.geekbrains.service.CategoryDTO;
import ru.geekbrains.service.CategoryServiceLocal;
import ru.geekbrains.service.ProductDTO;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class CategoryController implements Serializable {

    @EJB
    private CategoryServiceLocal categoryServiceLocal;

//    @EJB
//    private CategoryRepository categoryRepository;

    private CategoryDTO categoryDTO;

    private List<CategoryDTO> categoryDTOList;

    public String createCategory() {
        this.categoryDTO = new CategoryDTO();
        return "/category.xhtml?faces-redirect=true";
    }

    public List<CategoryDTO> getAllCategory() {
        return categoryDTOList;
    }

    public String editCategory(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
        return "/category.xhtml?faces-redirect=true";
    }

    public String deleteCategory(CategoryDTO categoryDTO) throws SQLException {
        categoryServiceLocal.delete(categoryDTO.getId());
        return "/category.xhtml?faces-redirect=true";
    }

    public String saveCategory() {
        if(categoryDTO.getId() == null) {
            categoryServiceLocal.insert(categoryDTO);
        } else {
            categoryServiceLocal.update(categoryDTO);
        }
        return "/category.xhtml?faces-redirect=true";
    }

    public String newCategory() {
        return "/new_category.xhtml?faces-redirect=true";
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
