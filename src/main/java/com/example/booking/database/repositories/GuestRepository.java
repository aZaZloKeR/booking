package com.example.booking.database.repositories;

import com.example.booking.database.Administrator;
import com.example.booking.database.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GuestRepository  extends CrudRepository<Guest,Integer> {
    Optional<Guest> findByLogin(String login);
}
