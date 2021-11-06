package eshop.eshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import eshop.eshop.model.Orders;
import eshop.eshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final UserService userService;

    @Override
    public Orders createOrder(List<Long> productIds, Long userId) {
        log.info("Creating order for user with id: {}", userId);
        Orders order = new Orders();
        order.setUser(userService.getUserById(userId));
        order.setProducts(productService.getProductsById(productIds));

        return orderRepository.save(order);

    }

    @Override
    public Orders getOrder(Long id) {
        log.info("Getting order: {}", id);
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Orders updateOrder(Long id, Orders order) {
        log.info("Updating order: {}", order);
        Orders orderToUpdate = orderRepository.findById(id).orElse(null);
        if (orderToUpdate == null) {
            return null;
        }
        else{
            orderToUpdate.setPaymentType(order.getPaymentType());
            orderToUpdate.setStatus(order.getStatus());
            return orderRepository.save(orderToUpdate);
        }
    }

    @Override
    public List<Orders> getAllOrders() {
        log.info("Getting all orders");
        return orderRepository.findAll();
    }

    
}
