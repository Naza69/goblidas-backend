package com.example.goblidas_backend.services;

import com.example.goblidas_backend.entities.UserAdress;
import com.example.goblidas_backend.repositories.UserAdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAdressService extends BaseService<UserAdress> {

   @Autowired
   private UserAdressRepository userAdressRepository;

    public UserAdressService(JpaRepository<UserAdress, Long> baseRepository) {
        super(baseRepository);
    }
}
