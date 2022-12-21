package com.example.booking.service;

import com.example.booking.database.HotelRoom;
import com.example.booking.database.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    @Autowired
    GuestRepository guestRepository;

}
