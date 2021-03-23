package com.alten.services.booking.controllers;

import com.alten.services.booking.exceptions.handlers.RestExceptionHandler;
import com.alten.services.booking.models.Booking;
import com.alten.services.booking.services.BookingService;
import com.alten.services.booking.util.validations.CheckDateValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest  {

    /*
    * To  give a chance to everyone to book the room, the stay can’t be longer than 3 days and can’t be reserved more than 30 days in advance.
      All reservations start at least the next day of booking,
      To simplify the use case, a  “DAY’ in the hotel room starts from 00:00 to 23:59:59.
      Every end-user can check the room availability, place a reservation, cancel it or modify it.To simplify the API is insecure.
    * */

    private MockMvc mvcMock;

    @MockBean
    private BookingService bookingService;

    @Before
    public void setUp(){
        bookingService = mock(BookingService.class);
        mvcMock = MockMvcBuilders.standaloneSetup(new BookingController(bookingService))
                .setControllerAdvice(new RestExceptionHandler(), new CheckDateValidator())
                .build();
    }

    @Test
    public void whenRetrievingBookingByIdAndTheIdIsNullShouldReturn400()
            throws Exception {
        final Booking booking = new Booking();

        given(bookingService.retrieveBooking(anyLong())).willReturn(booking);

        final Integer bookingId = null;

        mvcMock.perform(get("/booking/" + bookingId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        reset(bookingService);
    }

    @Test
    public void whenRetrievingBookingByIdAndTheIdDoesNotExistShouldReturn404()
            throws Exception {
        final Booking booking = new Booking();

        given(bookingService.retrieveBooking(anyLong())).willReturn(null);

        final Integer bookingId = 1;

        mvcMock.perform(get("/booking/" + bookingId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        reset(bookingService);
    }

    @Test
    public void whenRetrievingBookingByIdAndTheIdIsValidShouldReturn200()
            throws Exception {
        final Booking booking = new Booking();

        booking.setCheckIn(new Date());
        booking.setCheckOut(new Date());
        given(bookingService.retrieveBooking(anyLong())).willReturn(booking);

        final Integer bookingId = 1;

        mvcMock.perform(get("/booking/" + bookingId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        reset(bookingService);
    }

    //whenCreatingABookingAndTheDateIsGreaterThan3DaysShouldReturn400
    //whenCreatingABookingAndTheDateIsAfter30DaysInAdvanceShouldReturn400
    //whenCreatingABookingAndTheDataIsValidShouldReturn200
    @Test
    public void whenCreatingABookingAndTheCheckInDateIsNullShouldReturn400()
            throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final Booking booking = new Booking();

        booking.setCheckIn(null);
        given(bookingService.retrieveBooking(anyLong())).willReturn(booking);

        mvcMock.perform(post("/booking/")
                .content(mapper.writeValueAsString(booking))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        reset(bookingService);
    }

    @Test
    public void whenCreatingABookingAndTheCheckOutDateIsNullShouldReturn400()
            throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final Booking booking = new Booking();

        booking.setCheckOut(null);
        given(bookingService.retrieveBooking(anyLong())).willReturn(booking);

        final String request = mapper.writeValueAsString(booking);

        mvcMock.perform(post("/booking/")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        reset(bookingService);
    }

    @Test
    public void whenCreatingABookingAndTheGuestIdIsNullShouldReturn400()
            throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final Booking booking = new Booking();

        booking.setGuest(null);
        given(bookingService.retrieveBooking(anyLong())).willReturn(booking);

        mvcMock.perform(post("/booking/")
                .content(mapper.writeValueAsString(booking))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        reset(bookingService);
    }

    //whenUpdatingABookingByIdAndTheIdIsNullShouldReturn400
    //whenUpdatingABookingByIdAndTheIdDoesNotExistsShouldReturn404
    //whenUpdatingABookingAndTheCheckInDateIsNullShouldReturn400
    //whenUpdatingABookingAndTheCheckOutDateIsNullShouldReturn400
    //whenUpdatingABookingAndTheGuestIdIsNullShouldReturn400
    //whenUpdatingABookingAndTheDateIsGreaterThan3DaysShouldReturn400
    //whenUpdatingABookingAndTheDateIsAfter30DaysInAdvanceShouldReturn400
    //whenUpdatingABookingAndTheDataIsValidShouldReturn200

    //whenDeletingABookingByIdAndTheIdIsNullShouldReturn400
    //whenDeletingABookingByIdAndTheIdDoesNotExistsShouldReturn404
    //whenDeletingABookingByIdAndTheDataIsValidShouldReturn200


}