package com.example.goblidas_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_imagen")
@Setter
@Getter
public class DetailImage extends Base {

    @ManyToOne
    @MapsId("detailId")
    @JoinColumn(name = "id_detalle")
    private Detail detailId;

    @ManyToOne
    @MapsId("imageId")
    @JoinColumn(name = "id_imagen")
    private Image imageId;
}
