package com.example.booking.database.repositories;

import com.example.booking.database.HotelRoom;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelRoomRepository  extends CrudRepository<HotelRoom, Integer> {
    Optional<HotelRoom> findByNumber(String number);
    Iterable<HotelRoom> findAllByGuestId(Integer guestId);
}
