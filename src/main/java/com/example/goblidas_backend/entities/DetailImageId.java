package com.example.goblidas_backend.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DetailImageId implements Serializable {

    private Long detailId;
    private Long imageId;
}
