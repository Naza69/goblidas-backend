package com.example.goblidas_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedido_detalle")
@Getter
@Setter
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id = new OrderDetailId();

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "id_pedido", nullable = false)
    private Order orderId;

    @ManyToOne
    @MapsId("detailId")
    @JoinColumn(name = "id_detalle", nullable = false)
    private Detail detailId;
}
