package eshop.eshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import eshop.eshop.model.Category;
import eshop.eshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        log.info("Saving category: {}", category);
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        log.info("Getting category by id: {}", id);
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCategory(Long id) {
        log.info("Deleting category by id: {}", id);
        categoryRepository.deleteById(id);        
    }

    @Override
    public List<Category> getAllCategories() {
        log.info("Getting all categories");
        return categoryRepository.findAll();
    } 
}
