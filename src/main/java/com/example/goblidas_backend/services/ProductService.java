package com.example.goblidas_backend.services;

import com.example.goblidas_backend.entities.Product;
import com.example.goblidas_backend.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<Product> {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(JpaRepository<Product, Long> baseRepository){
        super(baseRepository);
    }


    //@Transactional
    //public Product crearProducto (
    //        CrearProductoDTO dto
    //) throws Exception {
    //    if (dto != null) {
    //        System.out.println("Modelo: " + dto.getModelo());
    //    }
    //    Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
    //            .orElseThrow(() -> new Exception("Categoria no encontrada"));
    //
    //    Producto producto = Producto.builder()
    //            .modelo(dto.getModelo().toUpperCase(Locale.ROOT))
    //            .sexo(dto.getSexo())
    //            .tipoProducto(dto.getTipoProducto())
    //            .categoria(categoria)
    //            .detalles(new ArrayList<>())
    //            .build();
    //    categoria.getProductos().add(producto);
    //    productoRepository.save(producto);
    //    return producto;
    //}

    @Transactional
    public List<Product> filtroProd (
            String sexo,
            String brand,
            Integer talleNumero,
            String productType,
            String nombre,
            String cateoria,
            Double min,
            Double max
    ) throws Exception {
        if (min != null && max != null && min > max) {
            throw new Exception("El valor de 'min' no puede ser mayor que 'max'.");
        }

        return productRepository.filter(sexo, brand, talleNumero, productType, nombre, cateoria, min, max);
    }

    public List<Product> orderAsc (
            List<Product> productos
    ) throws Exception {
        if (productos.isEmpty()) {
            throw new Exception("La lista esta vacia");
        }
        return productRepository.ordenarPrecioAsc(productos);
    }

    public List<Product> orderDesc (
            List<Product> productos
    ) throws Exception {
        if (productos.isEmpty()) {
            throw new Exception("La lista esta vacia");
        }
        return productRepository.ordenarPrecioDesc(productos);
    }
}
