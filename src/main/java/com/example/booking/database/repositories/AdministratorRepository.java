package com.example.booking.database.repositories;

import com.example.booking.database.Administrator;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdministratorRepository extends CrudRepository<Administrator,Integer> {
    Optional<Administrator> findByLogin(String login);
}
