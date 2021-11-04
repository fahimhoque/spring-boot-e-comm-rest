package eshop.eshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        log.info("Getting all categories");
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        log.info("Adding category");
        return ResponseEntity.ok(categoryService.addNewCategory(category));
    }

    @PostMapping("/add-product-to-category")
    public ResponseEntity<String> addProductToCategory(@RequestBody String categoryName, String productName
    ){
        log.info("Adding product to category");
        categoryService.addProductToCategory(categoryName, productName);
        // return a 200 OK response and success message
        return ResponseEntity.status(HttpStatus.OK).body("Product added to category");
    }
}
