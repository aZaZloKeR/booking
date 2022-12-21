package com.example.booking.database.repositories;

import com.example.booking.database.Date;
import org.springframework.data.repository.CrudRepository;

public interface DateRepository extends CrudRepository<Date,Integer> {
    Iterable<Date> findAllByHotelRoomId(Integer hotelRoomId);
}
