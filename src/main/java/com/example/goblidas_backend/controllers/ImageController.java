package com.example.goblidas_backend.controllers;

import com.example.goblidas_backend.entities.Image;
import com.example.goblidas_backend.services.ImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image")
public class ImageController extends BaseController<Image> {

    public ImageController(ImageService imageService){
        super(imageService);
    }
}
