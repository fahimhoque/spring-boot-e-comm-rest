package eshop.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import eshop.eshop.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    
}
