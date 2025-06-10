package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.DTOs.CreateOrderDTO;
import com.example.goblidas_backend.entities.Order;
import com.example.goblidas_backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController extends BaseController<Order> {

    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService){
        super(orderService);

    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        Order order = orderService.createOrderFromCart(createOrderDTO);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        try {
            List<Order> orders = orderService.findOrdersByUserId(userId);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
