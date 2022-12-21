package com.example.booking.controller;

import com.example.booking.database.Administrator;
import com.example.booking.database.Guest;
import com.example.booking.database.repositories.AdministratorRepository;
import com.example.booking.database.repositories.GuestRepository;
import com.example.booking.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController {
    @Autowired
    MainService mainService;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    AdministratorRepository administratorRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @PostMapping("/auth")
    public Object auth(@RequestBody Guest guest){
        System.out.println("login = " + guest.getLogin() + ", password = "+ guest.getPassword());
        Optional<Guest> byLogin = guestRepository.findByLogin(guest.getLogin());
        if(byLogin.isPresent()){

            Guest guest1 = byLogin.get();
            if(Objects.equals(guest1.getPassword(), guest.getPassword())){
                guest1.setRole("guest");
                return guest1;
            }
        }
        else if (administratorRepository.findByLogin(guest.getLogin()).isPresent()){
            Administrator administrator = administratorRepository.findByLogin(guest.getLogin()).get();
            if(Objects.equals(administrator.getPassword(), guest.getPassword())){
                administrator.setRole("admin");
                return administrator;
            }
        }
        return "-1";
    }
}
