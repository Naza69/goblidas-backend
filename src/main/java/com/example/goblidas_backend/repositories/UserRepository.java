package com.example.goblidas_backend.repositories;

import com.example.goblidas_backend.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}
