package com.example.booking.database.repositories;

import com.example.booking.database.Date;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DateRepository extends CrudRepository<Date,Integer> {
    Iterable<Date> findAllByHotelRoomId(Integer hotelRoomId);
    Optional<Date> findByDate(LocalDate date);
}
