package com.example.goblidas_backend.repositories;

import com.example.goblidas_backend.entities.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {
}
