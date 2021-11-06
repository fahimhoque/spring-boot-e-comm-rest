package eshop.eshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.eshop.model.Product;
import eshop.eshop.service.ProductService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/add/{categoryId}")
    public ResponseEntity<Product> addProduct(@RequestBody Product product, @PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.saveProduct(product, categoryId));
    }
}
