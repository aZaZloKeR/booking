package com.example.booking.database;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private int amountPlace;
    private int occupiedPlaces;
    private Integer guestId;
    @JoinColumn(name = "hotelRoomId")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Date> dates;
}
