package com.example.goblidas_backend.repositories;

import com.example.goblidas_backend.entities.DiscountPrice;
import com.example.goblidas_backend.entities.DiscountPriceId;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountPriceIdRepository extends BaseRepository<DiscountPrice, DiscountPriceId> {
}
