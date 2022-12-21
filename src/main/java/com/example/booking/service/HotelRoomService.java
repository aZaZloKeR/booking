package com.example.booking.service;

import com.example.booking.database.HotelRoom;
import com.example.booking.database.repositories.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelRoomService {
    @Autowired
    HotelRoomRepository hotelRoomRepository;

    public void addHotelRoom(String number, int amountPlace) {
        HotelRoom hotelRoom = new HotelRoom();
        hotelRoom.setNumber(number);
        hotelRoom.setAmountPlace(amountPlace);
        hotelRoom.setOccupiedPlaces(0);
        hotelRoomRepository.save(hotelRoom);
    }
}
