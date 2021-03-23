package com.alten.services.booking.services.impl;

import com.alten.services.booking.data.entities.BookingEntity;
import com.alten.services.booking.data.repositories.BookingRepository;
import com.alten.services.booking.mappers.BookingMapper;
import com.alten.services.booking.models.Booking;
import com.alten.services.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BookingServiceImpl implements BookingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingServiceImpl (BookingRepository bookingRepository, BookingMapper bookingMapper){
        this.bookingRepository = bookingRepository;
        this.bookingMapper= bookingMapper;

    }
    @Override
    public Booking retrieveBooking(Long id) {
        return null;
    }

    @Override
    public int createBooking(Booking booking) {
        BookingEntity bookingEntity= bookingMapper.modelToEntity(booking);
        bookingRepository.save(bookingEntity);

        return 1;
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
