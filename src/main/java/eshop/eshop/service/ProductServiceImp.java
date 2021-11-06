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
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product getProduct(Long productId) { 
        log.info("Getting product with id: {}", productId);
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product saveProduct(Product product, Long categoryId) {
        log.info("Saving product: {}", product);
        Product newProduct = productRepository.save(product);
        Category category = categoryRepository.findById(categoryId).orElse(null);
        category.getProducts().add(newProduct);
        categoryRepository.save(category);
        return newProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Getting all products");
        return productRepository.findAll();
    }



    

    
}
