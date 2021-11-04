package eshop.eshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import eshop.eshop.model.Category;
import eshop.eshop.model.Product;
import eshop.eshop.repository.CategoryRepository;
import eshop.eshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    @Override
    public Category getCategoryByName(String name) {
        log.info("getCategoryByName: {}", name);
        return categoryRepository.findByName(name);
    }

    @Override
    public Category addNewCategory(Category category) {
        log.info("addNewCategory: {}", category);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        log.info("getAllCategories");
        return categoryRepository.findAll();
    }

    @Override
    public void addProductToCategory(String categoryName, String productName) {
        log.info("addProductToCategory: {}", categoryName);
        Category category = categoryRepository.findByName(categoryName);
        Product product = productRepository.findByName(productName);
        category.getProducts().add(product);
    }
    
}
