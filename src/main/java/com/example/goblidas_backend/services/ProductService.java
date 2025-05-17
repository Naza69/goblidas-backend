package com.example.goblidas_backend.services;

import com.example.goblidas_backend.entities.Product;
import com.example.goblidas_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product> {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(JpaRepository<Product, Long> baseRepository){
        super(baseRepository);
    }
}
