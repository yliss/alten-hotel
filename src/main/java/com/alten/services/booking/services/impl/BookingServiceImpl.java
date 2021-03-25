package com.alten.services.booking.services.impl;

import com.alten.services.booking.data.entities.BookingEntity;
import com.alten.services.booking.data.entities.StatusEntity;
import com.alten.services.booking.data.repositories.BookingRepository;
import com.alten.services.booking.exceptions.InvalidDataException;
import com.alten.services.booking.exceptions.RecordNotFoundException;
import com.alten.services.booking.mappers.BookingMapper;
import com.alten.services.booking.models.Booking;
import com.alten.services.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.alten.services.booking.util.StringMessages.*;

@Service
public class BookingServiceImpl implements BookingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;

    }

    @Override
    public List<Booking> retrieveBooking() {
        Iterable<BookingEntity> bookingEntities = bookingRepository.findAll();

        return StreamSupport
                .stream(bookingEntities.spliterator(), false)
                .map(entity -> bookingMapper.entityToModel(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Booking retrieveBooking(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidDataException(BOOKING_ID_IS_REQUIRED);
        }

        Optional<BookingEntity> bookingEntityOptional = bookingRepository.findById(id);
        if (!bookingEntityOptional.isPresent()) {
            throw new RecordNotFoundException(BOOKING_DOES_NOT_EXIST);
        } else {
            return bookingMapper.entityToModel(bookingEntityOptional.get());
        }
    }

    @Override
    public int createBooking(Booking booking) {
        if (booking == null || booking.getGuest() == null) {
            throw new InvalidDataException(BOOKING_INFO_IS_REQUIRED);
        }

         BookingEntity bookingEntity = bookingMapper.modelToEntity(booking);
        StatusEntity status = new StatusEntity();
        status.setMessage("ACCEPTED");
        status.setCode("001");
        bookingEntity.setStatus(status);
        final BookingEntity objectSavedAtDB = bookingRepository.save(bookingEntity);

        if (objectSavedAtDB == null || objectSavedAtDB.getId() == null) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int updateBooking(Booking booking,Long id) {
        if (booking == null ||id == null ||booking.getGuest() == null) {
            throw new InvalidDataException(BOOKING_INFO_IS_REQUIRED);
        }
        final BookingEntity bookingEntity = bookingMapper.modelToEntity(booking);
        Optional<BookingEntity> bookingEntityOptional = bookingRepository.findById(id);

        if (!bookingEntityOptional.isPresent()) {
            throw new RecordNotFoundException(BOOKING_DOES_NOT_EXIST);
        }

        bookingEntity.setId(bookingEntityOptional.get().getId());
        final BookingEntity objectSavedAtDB = bookingRepository.save(bookingEntity);

        if (objectSavedAtDB == null || objectSavedAtDB.getId() == null) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int deleteBooking(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidDataException(BOOKING_ID_IS_REQUIRED);
        }

        Optional<BookingEntity> bookingEntityOptional = bookingRepository.findById(id);
        if (bookingEntityOptional.isPresent()) {
            throw new RecordNotFoundException(BOOKING_DOES_NOT_EXIST);
        } else {
            bookingRepository.delete(bookingEntityOptional.get());
            return 1;
        }
    }
}
