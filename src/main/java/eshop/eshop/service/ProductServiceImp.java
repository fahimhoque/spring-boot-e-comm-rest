package eshop.eshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import eshop.eshop.model.Product;
import eshop.eshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product addNewProduct(Product product) {   
        log.info("Saving: {}", product);
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    
}
