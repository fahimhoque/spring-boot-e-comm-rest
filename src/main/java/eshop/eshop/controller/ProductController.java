package eshop.eshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.eshop.model.Category;
import eshop.eshop.model.Product;
import eshop.eshop.service.CategoryService;
import eshop.eshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/all-products")
    public ResponseEntity<Product> getAllProducts() {
        log.info("getAllProducts()");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-new-product")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product, String categoryName) {
        // find category by name
        Category category = categoryService.getCategoryByName(categoryName);
        // add product to category
        categoryService.addProductToCategory(category.getName(), product.getName());  
        // add product to database
        Product savedProduct = productService.addNewProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED); 
    }


}
