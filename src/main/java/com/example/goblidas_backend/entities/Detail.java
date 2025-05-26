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
    private float[] brand;

    @Column(name = "stock")
    private float[] stock;

    @ManyToOne
    @JoinColumn(name = "id_precio", nullable = false)
    private Price prizeId;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Product productIdj;

    @ManyToOne
    @JoinColumn(name = "id_talle", nullable = false)
    private Size sizeId;
}
