package eshop.eshop.service;

import java.util.List;

import eshop.eshop.model.Product;

public interface ProductService {
    Product addNewProduct(Product product);
    Product getProduct(String name);
    List<Product> getAllProducts();
}
