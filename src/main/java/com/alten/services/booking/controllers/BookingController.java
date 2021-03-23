package com.alten.services.booking.controllers;

import com.alten.services.booking.models.Booking;
import com.alten.services.booking.models.Message;
import com.alten.services.booking.models.RetrieveBookingResponse;
import com.alten.services.booking.models.Status;
import com.alten.services.booking.services.BookingService;
import com.alten.services.booking.util.validations.CheckDates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.alten.services.booking.util.StringMessages.CHECKIN_AND_CHECKOUT_DATES_ARE_REQUIRED;

@Controller
@RequestMapping(path = "/booking")
@Validated
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    @RequestMapping(path = "/{id}")
    public ResponseEntity<RetrieveBookingResponse> retrieveBooking(@PathVariable("id") Long id) {
        final Booking booking = bookingService.retrieveBooking(id);

        RetrieveBookingResponse bookingResponse = new RetrieveBookingResponse();
        HttpStatus reponseStatus = null;

        if (booking != null) {
            reponseStatus = HttpStatus.OK;
            Status status = new Status();
            status.setMessage("The booking was ");
            bookingResponse.setStatus(status);
            bookingResponse.setBooking(booking);
        } else {
            Status status = new Status();
            status.setMessage("The booking was ");
            bookingResponse.setStatus(status);
            reponseStatus = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(reponseStatus).body(bookingResponse);
    }

    @PostMapping
    public ResponseEntity<Message> creatingBooking(@RequestBody
                                                   @Valid
                                                   @CheckDates(message = CHECKIN_AND_CHECKOUT_DATES_ARE_REQUIRED)
                                                               Booking booking) {
        Message message = new Message();
        HttpStatus status;

        int theRecordWasCreated = bookingService.updateBooking(booking);
        if (theRecordWasCreated > 0) {
            message.setDescription("The booking was created successful");

            status = HttpStatus.OK;
        } else {
            message.setDescription("The booking was not created");

            status = HttpStatus.NO_CONTENT;
        }

        return ResponseEntity.status(status).body(message);
    }
}

