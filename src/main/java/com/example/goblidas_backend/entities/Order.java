package com.example.goblidas_backend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class Order extends Base {
    @Column(name = "total")
    private Float summary;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @Column(name = "fecha")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_usuario_direccion", nullable = false)
    private UserAdress userAdressId;

}
