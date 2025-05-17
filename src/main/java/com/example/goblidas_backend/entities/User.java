package com.example.goblidas_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
//package com.example.goblidas_backend.enums;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class User extends Base {
    @Column(name = "nombre")
    private String name;

    @Column(name = "contraseña")
    private String password;

    //Faltaria enum rol de usuario (O admin o customer)

    @Column(name = "email")
    private String email;

    @Column(name = "dni")
    private String dni;


}
