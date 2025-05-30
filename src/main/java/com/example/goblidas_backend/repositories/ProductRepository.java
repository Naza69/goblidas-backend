package com.example.goblidas_backend.repositories;

import com.example.goblidas_backend.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
    @Query("SELECT DISTINCT p " +
            "FROM Producto p " +
            "JOIN p.detalles d " +
            "JOIN d.talle t " +
            "WHERE (:sexoParam IS NULL OR :sexoParam = p.sexo) " +
            "AND (:marcaParam IS NULL OR :marcaParam = d.marca) " +
            "AND (:talleParam IS NULL OR :talleParam = t.numero) " +
            "AND (:tipoProdParam IS NULL OR :tipoProdParam = p.tipoProducto) " +
            "AND (:nombreParam IS NULL OR :nombreParam = p.modelo) " +
            "AND (:categoriaParam IS NULL OR :categoriaParam = p.categoria.nombre) " +
            "AND ((:min IS NULL AND :max IS NULL) " +
            "OR (:min IS NOT NULL AND :max IS NOT NULL AND d.precio.precioVenta BETWEEN :min AND :max))")
    List<Product> filter(
            @Param("sexoParam") String gender,
            @Param("marcaParam") String brand,
            @Param("talleParam") Integer talle,
            @Param("tipoProdParam") String productType,
            @Param("nombreParam") String nombre,
            @Param("categoriaParam") String category,
            @Param("min") Double min,
            @Param("max") Double max
    );


    @Query("SELECT d.producto " +
            "FROM Detalle d " +
            "WHERE d.producto " +
            "IN :productos " +
            "ORDER BY d.precio.precioVenta DESC")
    List<Product> ordenarPrecioDesc(
            @Param("productos") List<Product> productos
    );


    @Query("SELECT d.producto " +
            "FROM Detalle d " +
            "WHERE d.producto " +
            "IN :productos " +
            "ORDER BY d.precio.precioVenta ASC")
    List<Product> ordenarPrecioAsc (
            @Param("productos") List<Product> products
    );
}
