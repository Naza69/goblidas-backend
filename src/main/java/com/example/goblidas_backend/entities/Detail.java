package com.example.goblidas_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle")
@Getter
@Setter
public class Detail extends Base {
    @Column(name = "estado")
    private Boolean state;

    @Column(name = "color")
    private String colour;

    //No se si estos dos tipos sean correctos
    @Column(name = "marca")
    private byte[] brand;

    @Column(name = "stock")
    private byte[] stock;

    @ManyToOne
    @JoinColumn(name = "id_precio", nullable = false)
    private Price prizeId;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Product productIdj;

    @ManyToOne
    @JoinColumn(name = "id_talle")
    private Size sizeId;
}
