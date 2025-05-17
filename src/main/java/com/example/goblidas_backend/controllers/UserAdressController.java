package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.entities.UserAdress;
import com.example.goblidas_backend.services.UserAdressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/useradress")
public class UserAdressController extends BaseController<UserAdress> {

    public UserAdressController(UserAdressService userAdressService){
        super(userAdressService);
    }
}
