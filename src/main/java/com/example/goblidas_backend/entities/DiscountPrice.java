package com.example.goblidas_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "precio_con_descuento")
@Getter
@Setter
public class DiscountPrice extends Base {

    @EmbeddedId
    private DiscountPriceId id;

    @ManyToOne
    @MapsId("discountId")
    @JoinColumn(name = "id_descuento", nullable = false)
    private Discount discountId;

    @ManyToOne
    @MapsId("priceId")
    @JoinColumn(name = "id_precio", nullable = false)
    private Price priceId;

}
