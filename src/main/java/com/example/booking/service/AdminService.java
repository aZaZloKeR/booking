package com.example.booking.service;

import com.example.booking.database.Date;
import com.example.booking.database.HotelRoom;
import com.example.booking.database.repositories.AdministratorRepository;
import com.example.booking.database.repositories.DateRepository;
import com.example.booking.database.repositories.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdministratorRepository administratorRepository;
    @Autowired
    HotelRoomRepository hotelRoomRepository;
    @Autowired
    DateRepository dateRepository;

    public Iterable<HotelRoom> getAllHotelRooms() {
        return hotelRoomRepository.findAll();
    }

/*    public Iterable<Date> getAllDateByHotelRoom(Iterable<HotelRoom> allHotelRooms) {
        for(HotelRoom room : allHotelRooms){
            room.setDates((List<Date>) dateRepository.findAllByHotelRoomId(room.getId()));
        }
    }*/
}
