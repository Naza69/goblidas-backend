package com.example.goblidas_backend.repositories;

import com.example.goblidas_backend.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
}
