package com.example.goblidas_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "imagen")
@Getter
@Setter
public class Image extends Base {
    @Column(name = "url")
    private String url;
}
