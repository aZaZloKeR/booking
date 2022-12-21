package com.example.booking.controller;

import com.example.booking.database.Guest;
import com.example.booking.database.HotelRoom;
import com.example.booking.restModel.GuestBook;
import com.example.booking.service.AdminService;
import com.example.booking.service.DateService;
import com.example.booking.service.GuestService;
import com.example.booking.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/admin")
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
    public void addHotelRoom(@RequestBody HotelRoom hotelRoom){
        hotelRoomService.addHotelRoom(hotelRoom.getNumber(),hotelRoom.getAmountPlace());
    }
    @PostMapping("/book")
    public void addBooking(@RequestBody GuestBook guestBook){
        guestService.bookHotelRoom(guestBook);
    }
    @GetMapping("/guests")
    public Iterable<Guest> getAllGuest(){
        System.out.println("dawda");
        return guestService.getAllGuests();
    }

}
