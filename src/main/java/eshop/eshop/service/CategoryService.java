package eshop.eshop.service;

import java.util.List;

import eshop.eshop.model.Category;

public interface CategoryService {
    Category getCategoryByName(String name);
    Category addNewCategory(Category category);
    List<Category> getAllCategories();

    void addProductToCategory(String categoryName, String productName);

}
