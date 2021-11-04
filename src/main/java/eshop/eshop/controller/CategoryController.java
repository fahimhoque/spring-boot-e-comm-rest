package eshop.eshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.eshop.model.Category;
import eshop.eshop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController 
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/all-categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        log.info("Getting all categories");
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping("/add-new-category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        log.info("Adding category");
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @DeleteMapping("/delete-category/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        log.info("Deleting category");
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category with id: " + id + " deleted");
    }
}
