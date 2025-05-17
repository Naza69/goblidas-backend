package com.example.goblidas_backend.services;

import com.example.goblidas_backend.entities.Detail;
import com.example.goblidas_backend.repositories.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DetailService extends BaseService<Detail> {

    @Autowired
    private DetailRepository detailRepository;

    public DetailService(JpaRepository<Detail, Long> baseRepository){
        super(baseRepository);
    }
}
