package com.example.goblidas_backend.repositories;

import com.example.goblidas_backend.entities.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends BaseRepository<Order, Long> {
}
