package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.DTOs.CreateOrderDTO;
import com.example.goblidas_backend.entities.Order;
import com.example.goblidas_backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
