package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.entities.DetailImage;
import com.example.goblidas_backend.services.DetailImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detailimage")
public class DetailImageController extends BaseController<DetailImage> {

    public DetailImageController(DetailImageService detailImageService){
        super(detailImageService);
    }
}
