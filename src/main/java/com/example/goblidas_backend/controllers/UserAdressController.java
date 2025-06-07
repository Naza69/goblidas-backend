package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.entities.User;
import com.example.goblidas_backend.entities.UserAdress;
import com.example.goblidas_backend.services.UserAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/useradress")
public class UserAdressController extends BaseController<UserAdress> {

    @Autowired
    private UserAdressService userAdressService;

    public UserAdressController(UserAdressService userAdressService){
        super(userAdressService);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserAdress>> getUserAdressByUserId(@PathVariable Long userId){
        List<UserAdress> adresses = userAdressService.getUserAdressesByUserId(userId);
        return ResponseEntity.ok(adresses);
    }
}
