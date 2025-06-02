package com.example.goblidas_backend.repositories;

import com.example.goblidas_backend.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
    @Query("SELECT p FROM Product p " +
            "WHERE (:gender IS NULL OR p.gender = :gender) " +
            "AND (:name IS NULL OR p.name LIKE %:name%) " +
            "AND (:productType IS NULL OR p.productType = :productType) " +
            "AND (:category IS NULL OR p.categoryId.name = :category)")
    List<Product> filter(
            @Param("name") String name,
            @Param("gender") String gender,
            //@Param("marcaParam") String brand,
            //@Param("talleParam") Integer talle,
            @Param("productType") String productType,
            @Param("category") String category
            //@Param("min") Double min,
            //@Param("max") Double max
    );


    //@Query("SELECT d.producto " +
    //        "FROM Detalle d " +
    //        "WHERE d.producto " +
    //        "IN :productos " +
    //        "ORDER BY d.precio.precioVenta DESC")
    //List<Product> ordenarPrecioDesc(
    //        @Param("productos") List<Product> productos
    //);


    //@Query("SELECT d.producto " +
    //        "FROM Detalle d " +
    //        "WHERE d.producto " +
    //        "IN :productos " +
    //        "ORDER BY d.precio.precioVenta ASC")
    //List<Product> ordenarPrecioAsc (
    //        @Param("productos") List<Product> products
    //);


    @Query("SELECT p FROM Product p WHERE p IN :products ORDER BY p.name ASC")
    List<Product> orderByNameAsc(@Param("products") List<Product> products);

    @Query("SELECT p FROM Product p WHERE p IN :products ORDER BY p.name DESC")
    List<Product> orderByNameDesc(@Param("products") List<Product> products);
}
