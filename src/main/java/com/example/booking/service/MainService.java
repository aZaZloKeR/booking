package com.example.booking.service;

import com.example.booking.database.Administrator;
import com.example.booking.database.Guest;
import com.example.booking.database.repositories.AdministratorRepository;
import com.example.booking.database.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class MainService {
    @Autowired
    AdminService adminService;
    @Autowired
    GuestService guestService;
    @Autowired
    AdministratorRepository administratorRepository;
    @Autowired
    GuestRepository guestRepository;

    public String checkRole(String login, String password) {
        Optional<Administrator> isAdmin = administratorRepository.findByLogin(login);
        Optional<Guest> isGuest = guestRepository.findByLogin(login);
        if(isAdmin.isPresent()){
            Administrator admin = isAdmin.get();
            if(Objects.equals(admin.getPassword(), password)){
                return "admin";
            }
        }
        else if(isGuest.isPresent()){
            Guest guest = isGuest.get();
            if(Objects.equals(guest.getPassword(),password)){
                return "guest";
            }
        }
        return "unauthorized";
    }
}
