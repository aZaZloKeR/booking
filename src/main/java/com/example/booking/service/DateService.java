package com.example.booking.service;

import com.example.booking.database.Date;
import com.example.booking.database.repositories.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DateService {
    @Autowired
    DateRepository dateRepository;

    public void addBookingToDate(LocalDate date, boolean isBooking) {
        Optional<Date> dateFromBd = dateRepository.findByDate(date);
        if (dateFromBd.isPresent()) {
            Date date1 = dateFromBd.get();
            date1.setBook(isBooking);
            dateRepository.save(date1);
        }
    }
}
