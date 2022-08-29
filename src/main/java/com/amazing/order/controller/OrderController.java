package com.amazing.order.controller;

import com.amazing.order.entity.Order;
import com.amazing.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody Order order){
        orderService.saveOrder(order);
        return ResponseEntity.ok("Order saved");
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable String orderId){
        Order order = orderService.getOrderById(Integer.valueOf(orderId));
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrder(){
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
