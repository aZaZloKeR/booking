package com.example.booking.controller;

import com.example.booking.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:4200")
@Controller("/guest")
public class GuestController {
    @Autowired
    GuestService guestService;

    @PostMapping("/user")
    public void updateGuest(@RequestParam Integer id,@RequestParam String login,@RequestParam String password){
        guestService.updateGuest(id,login,password);
    }
    @PostMapping("/book")
    public void bookHotelRoom(){

    }


}
