package com.example.booking.service;

import com.example.booking.database.Date;
import com.example.booking.database.Guest;
import com.example.booking.database.HotelRoom;
import com.example.booking.database.repositories.DateRepository;
import com.example.booking.database.repositories.GuestRepository;
import com.example.booking.database.repositories.HotelRoomRepository;
import com.example.booking.restModel.GuestBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    HotelRoomRepository hotelRoomRepository;
    @Autowired
    DateRepository dateRepository;

    public Iterable<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public void updateGuest(Integer id, String password) {
        Optional<Guest> guest = guestRepository.findById(id);
        if(guest.isPresent()){
            Guest guest1 = guest.get();
            guest1.setPassword(password);
            guestRepository.save(guest1);
        }
    }

    public void bookHotelRoom(GuestBook guestBook) {
        int guestId = guestBook.getUserId();
        Optional<Guest> byId = guestRepository.findById(guestId);
        if(byId.isPresent()){
            Optional<HotelRoom> byNumber = hotelRoomRepository.findByNumber(guestBook.getNumber());
            if (byNumber.isPresent()){
                HotelRoom hotelRoom = byNumber.get();
                List<LocalDate> totalDates = new ArrayList<>();
                LocalDate start = guestBook.getStart();
                while (!start.isAfter(guestBook.getEnd())) {
                    totalDates.add(start);
                    start = start.plusDays(1);
                }
                List<Date> dates = new ArrayList<>();
                for (LocalDate localDate:totalDates) {
                    Optional<Date> byHotelRoomIdAndDate = dateRepository.findByHotelRoomIdAndDate(hotelRoom.getId(), localDate);
                    Date date;
                    if(byHotelRoomIdAndDate.isPresent()){
                        date = byHotelRoomIdAndDate.get();
                    }else {
                        date = new Date();
                        date.setHotelRoomId(hotelRoom.getId());
                        date.setDate(localDate);
                    }
                    date.setBook(true);
                    dates.add(date);
                }
                hotelRoom.setDates(dates);
                hotelRoom.setGuestId(guestId);
                hotelRoomRepository.save(hotelRoom);
            }

        }
    }

    public List<LocalDate> getAllDateByGuest(Integer guestId) {
        List<LocalDate> result = new ArrayList<>();
        if(guestRepository.findById(guestId).isPresent()){
            Iterable<HotelRoom> allByGuestId = hotelRoomRepository.findAllByGuestId(guestId);
            for (HotelRoom hotelRoom: allByGuestId){
                for (Date date : hotelRoom.getDates()) {
                    if (date.isBook()) {
                        result.add(date.getDate());
                    }
                }
            }
        }
        return result;
    }
}
