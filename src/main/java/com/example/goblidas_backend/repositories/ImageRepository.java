package com.example.goblidas_backend.repositories;

import com.example.goblidas_backend.entities.Image;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends BaseRepository<Image, Long> {
}
