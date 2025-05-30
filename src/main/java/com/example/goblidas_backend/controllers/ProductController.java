package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.entities.Product;
import com.example.goblidas_backend.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/product")
public class ProductController extends BaseController<Product> {
    public ProductController(ProductService productService){
        super(productService);
    }


    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProduct(
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Integer talleNumero,
            @RequestParam(required = false) String productType,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double min,
            @RequestParam(required = false) Double max,
            @RequestParam(required = false) Boolean asc,
            @RequestParam(required = false) Boolean desc
    ) throws Exception {
        try {
            List<Product> productos = ProductService.filtroProd(gender, brand, talleNumero, productType, modelo.toUpperCase(Locale.ROOT), category, min, max);
            if (productos.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                if (asc == null) {
                    asc = false;
                }

                if (desc == null) {
                    desc = false;
                }

                if (asc) {
                    List<Product> productosOrdAsc = ProductService.orderAsc(productos);
                    return ResponseEntity.ok(productosOrdAsc);
                } else if (desc) {
                    List<Product> productosOrdDesc = ProductService.orderDesc(productos);
                    return ResponseEntity.ok(productosOrdDesc);
                }

                return ResponseEntity.ok(productos);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
}
