package eshop.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.eshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
