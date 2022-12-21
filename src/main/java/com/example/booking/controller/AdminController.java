package com.example.booking.controller;

import com.example.booking.database.Date;
import com.example.booking.database.Guest;
import com.example.booking.database.HotelRoom;
import com.example.booking.database.repositories.HotelRoomRepository;
import com.example.booking.service.AdminService;
import com.example.booking.service.DateService;
import com.example.booking.service.GuestService;
import com.example.booking.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    GuestService guestService;
    @Autowired
    HotelRoomService hotelRoomService;
    @Autowired
    DateService dateService;

    @GetMapping("/hotelRooms")
    public Iterable<HotelRoom> login() {
        return adminService.getAllHotelRooms();
    }

    @PostMapping("/hotelRoom")
    public void addHotelRoom(@RequestParam String number, @RequestParam int amountPlace){
        hotelRoomService.addHotelRoom(number,amountPlace);
    }
    @PostMapping("/booking")
    public void addBooking(@RequestParam LocalDate date,@RequestParam boolean isBooking){
        dateService.addBookingToDate(date,isBooking);
    }
    @GetMapping("/guests")
    public Iterable<Guest> getAllGuest(){
        return guestService.getAllGuests();
    }

}
