package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.entities.Detail;
import com.example.goblidas_backend.services.DetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/detail")
public class DetailController extends BaseController<Detail> {

    public DetailController(DetailService detailService){
        super(detailService);
    }
}
