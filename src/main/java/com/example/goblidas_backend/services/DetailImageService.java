package com.example.goblidas_backend.services;

import com.example.goblidas_backend.entities.DetailImage;
import com.example.goblidas_backend.repositories.DetailImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DetailImageService extends BaseService<DetailImage> {
    @Autowired
    private DetailImageRepository detailImageRepository;

    public DetailImageService(JpaRepository<DetailImage, Long> baseRepository){
        super(baseRepository);
    }
}
