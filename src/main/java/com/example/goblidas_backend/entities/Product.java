package com.example.goblidas_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
public class Product extends Base {

    //No se si este tipo este bien
    @Column(name = "tipo_producto")
    private byte productType;

    @Column(name = "nombre")
    private String name;

    @Column(name = "sexo")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Category categoryId;

}
