package com.example.goblidas_backend.repositories;

import com.example.goblidas_backend.entities.DetailImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailImageRepository extends JpaRepository<DetailImage, Long> {
}
