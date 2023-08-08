package com.example.bmsjul23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel{

    private String name;
    SeatStatus status;
    SeatType seatType;
    int topleftX;
    int topleftY;
    int BottomRightX;
    int BottomRightY;
    @ManyToOne
    Screen screen;
    @ManyToOne
    Ticket ticket;


}
