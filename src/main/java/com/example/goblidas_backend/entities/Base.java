package com.example.goblidas_backend.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
@MappedSuperclass
@Data
public abstract class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
