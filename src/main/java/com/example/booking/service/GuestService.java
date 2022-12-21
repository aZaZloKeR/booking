package com.example.booking.service;

import com.example.booking.database.Guest;
import com.example.booking.database.HotelRoom;
import com.example.booking.database.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestService {
    @Autowired
    GuestRepository guestRepository;

    public Iterable<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public void updateGuest(Integer id, String password) {
        Optional<Guest> guest = guestRepository.findById(id);
        if(guest.isPresent()){
            Guest guest1 = guest.get();
            guest1.setPassword(password);
            guestRepository.save(guest1);
        }
    }
}
