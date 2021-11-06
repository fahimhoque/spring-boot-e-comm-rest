package eshop.eshop.service;

import java.util.List;

import eshop.eshop.model.Orders;

public interface OrderService {
    Orders createOrder(List<Long> productIds, Long userId);
    Orders getOrder(Long id);
    Orders updateOrder(Long id, Orders order);

    List<Orders> getAllOrders();
    
}
