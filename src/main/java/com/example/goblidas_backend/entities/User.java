package com.example.goblidas_backend.entities;

import com.example.goblidas_backend.entities.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
//package com.example.goblidas_backend.enums;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class User extends Base implements UserDetails {

    @NonNull
    @Column(name = "nombre")
    private String name;

    @Column(name = "contraseña")
    @JsonIgnore
    private String password;

    //Faltaria enum rol de usuario (O admin o customer)
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private Role role = Role.CUSTOMER;

    @Column(name = "email")
    private String email;

    @Column(name = "dni")
    private String dni;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email; // Spring Security va a usar esto como identificador único
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }


    public Role getRole() {
        return role;
    }

    //@Override
    //public Collection<? extends GrantedAuthority> getAuthorities() {
    //    return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name())); // Se devuelve el role
    //}

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name())); // Se devuelve el role
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
