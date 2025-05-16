package com.example.goblidas_backend.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {
    private Long orderId;
    private Long detailId;
}
