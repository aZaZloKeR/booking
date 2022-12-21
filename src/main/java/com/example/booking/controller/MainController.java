package com.example.booking.controller;

import com.example.booking.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @PostMapping("/auth")
    public String auth(@RequestParam String login, @RequestParam String password, Model model){
        System.out.println("login = " + login + ", password = "+ password);
        String role = mainService.checkRole(login,password);
        if(Objects.equals(role, "admin")){
            model.addAttribute("role","admin");
            return "admin";
        }
        else if(Objects.equals(role, "guest")){
            model.addAttribute("role","guest");
            return "guest";
        }
        return "login";
    }
}
