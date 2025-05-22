package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.entities.User;
import com.example.goblidas_backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User> {

    public UserController(UserService userService){
        super(userService);
    }

    @GetMapping("/profile")
    public ResponseEntity<String> getProfile() {
        return ResponseEntity.ok("Perfil de usuario autenticado");
    }
}
