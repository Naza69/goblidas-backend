package com.example.goblidas_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class Product extends Base {

    //No se si este tipo este bien
    @Column(name = "tipo_producto")
    private String productType;

    @Column(name = "nombre")
    private String name;

    @Column(name = "sexo")
    private String gender;

    //@ManyToOne
    //@JoinColumn(name = "id_categoria", nullable = false)
    //private Category categoryId;


    @ManyToMany
    @JoinTable(
            name = "producto_categoria",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<Category> categories = new ArrayList<>();
}
