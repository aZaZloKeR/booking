package com.example.booking.database.repositories;

import com.example.booking.database.Administrator;
import com.example.booking.database.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
// все репозитории - это интерфейс создающий автоматический Select в базу данных, по имени функции
public interface GuestRepository  extends CrudRepository<Guest,Integer> {
    Optional<Guest> findByLogin(String login);
}
