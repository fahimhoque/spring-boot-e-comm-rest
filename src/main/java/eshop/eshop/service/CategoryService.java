package eshop.eshop.service;

import java.util.List;

import eshop.eshop.model.Category;

public interface CategoryService {
    Category saveCategory(Category category);
    Category getCategoryById(Long id);
    void deleteCategory(Long id);
    List<Category> getAllCategories();
}
