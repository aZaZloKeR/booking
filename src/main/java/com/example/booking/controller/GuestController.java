package com.example.booking.controller;

import com.example.booking.database.Guest;
import com.example.booking.database.repositories.GuestRepository;
import com.example.booking.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller("/guest")
public class GuestController {
    @Autowired
    GuestService guestService;

    @PostMapping("/user")
    public void updateGuest(@RequestParam Integer id,@RequestParam String login,@RequestParam String password){
        guestService.updateGuest(id,login,password);
    }


}
