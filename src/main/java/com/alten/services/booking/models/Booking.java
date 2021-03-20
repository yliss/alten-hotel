package com.alten.services.booking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Booking {
    Long id;
    Guest guest;
    Date checkIn;
    Date checkOut;
    Status status;
}
