package com.alten.services.booking.services;

import com.alten.services.booking.models.Booking;

public interface BookingService {
    Booking retrieveBooking(Long id);
    int createBooking(Booking booking);
    int updateBooking(Booking booking);
    int deleteBooking(Long id);
}
