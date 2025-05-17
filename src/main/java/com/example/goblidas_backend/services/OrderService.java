package com.example.goblidas_backend.services;

import com.example.goblidas_backend.entities.Order;
import com.example.goblidas_backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<Order> {

    @Autowired
    private OrderRepository orderRepository;

    public OrderService(JpaRepository<Order, Long> baseRepository){
        super(baseRepository);
    }
}
