package eshop.eshop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import eshop.eshop.model.Orders;
import eshop.eshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController 
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    
    private final OrderService orderService;

    @GetMapping("/get-all-orders")
    public ResponseEntity<List<Orders>> getAllOrders() {
        log.info("getAllOrders()");
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/get-order/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable Long id) {
        log.info("getOrder()");
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @PostMapping("/create-order")
    public ResponseEntity<Orders> createOrder(@RequestBody List<Long> productIds, @RequestBody Long userId) {
        log.info("createOrder()");
        return ResponseEntity.ok(orderService.createOrder(productIds, userId));
    }    

}
