package com.example.goblidas_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_imagen")
@Setter
@Getter
public class DetailImage {

    @EmbeddedId
    private DetailImageId id = new DetailImageId();

    @Column(name = "activo")
    private Boolean active = true;

    @ManyToOne
    @MapsId("detailId")
    @JoinColumn(name = "id_detalle", nullable = false)
    private Detail detailId;

    @ManyToOne
    @MapsId("imageId")
    @JoinColumn(name = "id_imagen", nullable = false)
    private Image imageId;
}
