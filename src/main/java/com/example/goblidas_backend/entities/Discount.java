package com.example.goblidas_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "descuento")
@Getter
@Setter
public class Discount extends Base {
    @Column(name = "fecha_final")
    private LocalDateTime finalDate;

    @Column(name = "fecha_inicio")
    private LocalDateTime initialDate;

    @Column(name = "procentaje")
    private byte percentage;
}
