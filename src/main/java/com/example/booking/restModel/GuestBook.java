package com.example.booking.restModel;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GuestBook {
    private String number;
    private LocalDate start;
    private LocalDate end;
    private int userId;
}
