package com.alten.services.booking.services.impl;

import com.alten.services.booking.models.Booking;
import com.alten.services.booking.services.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public Booking retrieveBooking(Long id) {
        return null;
    }

    @Override
    public int createBooking(Booking booking) {
        return 0;
    }

    @Override
    public int updateBooking(Booking booking) {
        return 0;
    }

    @Override
    public int deleteBooking(Booking booking) {
        return 0;
    }
}
