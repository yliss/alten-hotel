package com.alten.services.booking.services;

import com.alten.services.booking.models.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> retrieveBooking();
    Booking retrieveBooking(Long id);
    int createBooking(Booking booking);
    int updateBooking(Booking booking,Long id);
    int deleteBooking(Long id);
}
