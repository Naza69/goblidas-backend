package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.entities.Product;
import com.example.goblidas_backend.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController extends BaseController<Product> {
    public ProductController(ProductService productService){
        super(productService);
    }
}
