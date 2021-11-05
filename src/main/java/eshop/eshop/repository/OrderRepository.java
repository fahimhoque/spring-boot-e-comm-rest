package eshop.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.eshop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
