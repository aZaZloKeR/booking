package com.example.booking.controller;

import com.example.booking.database.Date;
import com.example.booking.database.HotelRoom;
import com.example.booking.database.repositories.HotelRoomRepository;
import com.example.booking.service.AdminService;
import com.example.booking.service.GuestService;
import com.example.booking.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    GuestService guestService;
    @Autowired
    HotelRoomService hotelRoomService;
    @Autowired
    HotelRoomRepository roomRepository;

    @GetMapping("/hotelRooms")
    public String login(Model model) {
        Iterable<HotelRoom> allHotelRooms = adminService.getAllHotelRooms();
        for (HotelRoom room: allHotelRooms) {
            System.out.println(room.getId() + "    " + room.getDates() + "|||||||");
        }
        model.addAttribute("allHotelRooms",allHotelRooms);
        return "allHotelRooms";
    }

    @PostMapping("/hotelRoom")
    public String addHotelRoom(@RequestParam String number, @RequestParam int amountPlace,Model model){
        hotelRoomService.addHotelRoom(number,amountPlace);
        Iterable<HotelRoom> rooms = roomRepository.findAll();
        model.addAttribute("allHotelRooms",rooms);
        return "allHotelRooms";
    }
    @PostMapping("/booking")
    public void addBooking(@RequestParam LocalDate date,boolean isBooking){

    }

}
