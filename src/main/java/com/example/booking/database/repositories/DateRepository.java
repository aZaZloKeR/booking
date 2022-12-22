package com.example.booking.database.repositories;

import com.example.booking.database.Date;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DateRepository extends CrudRepository<Date,Integer> {
    Optional<Date> findByDate(LocalDate date);
    Optional<Date> findByHotelRoomIdAndDate(Integer hotelRoomId, LocalDate date);
}
