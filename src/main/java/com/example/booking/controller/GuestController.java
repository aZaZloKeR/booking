package com.example.booking.controller;

import com.example.booking.database.Guest;
import com.example.booking.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    GuestService guestService;

    @PostMapping("/user")
    public void updateGuest(@RequestBody Guest guest){
        guestService.updateGuest(guest.getId(),guest.getPassword());
    }
    @PostMapping("/book")
    public void bookHotelRoom(){

    }


}
