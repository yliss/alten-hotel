package com.alten.services.booking.controllers;

import com.alten.services.booking.models.Booking;
import com.alten.services.booking.models.Message;
import com.alten.services.booking.models.RetrieveBookingResponse;
import com.alten.services.booking.models.Status;
import com.alten.services.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.alten.services.booking.util.StringMessages.*;
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
    public ResponseEntity <RetrieveBookingResponse> getBooking(@PathVariable("id") Long id){
        final Booking booking = bookingService.getBooking(id);

        RetrieveBookingResponse bookingResponse = new RetrieveBookingResponse();
        HttpStatus reponseStatus = null;

        if (booking != null){
            reponseStatus = HttpStatus.OK;
            Status  status = new Status();
            status.setMessage("The booking was ");
        }
        else {
            reponseStatus = HttpStatus.NO_CONTENT;
        }

        return ResponseEntity.status(reponseStatus).body(bookingResponse);
    }

    @PostMapping
    public ResponseEntity <Message> getBooking(@RequestBody Booking booking){
        Message message = new Message();
        HttpStatus status;
        status = HttpStatus.OK;
        message.setDescription(BOOKING_INFO_ISREQUIRED);


     return ResponseEntity.status(status).body(null);
    }
}

