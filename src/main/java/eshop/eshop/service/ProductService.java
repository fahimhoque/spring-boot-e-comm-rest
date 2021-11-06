package eshop.eshop.service;

import java.util.List;

import eshop.eshop.model.Product;

public interface ProductService {
    Product getProduct(Long productId);
    Product saveProduct(Product product, Long categoryId);

    List<Product> getAllProducts();

    List<Product> getProductsById(List<Long> productIds);
}
