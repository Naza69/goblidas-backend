package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.entities.Order;
import com.example.goblidas_backend.services.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController extends BaseController<Order> {

    public OrderController(OrderService orderService){
        super(orderService);
    }

}
