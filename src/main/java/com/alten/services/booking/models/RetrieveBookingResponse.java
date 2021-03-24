package com.alten.services.booking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RetrieveBookingResponse {
    private Status status;
    private List<Booking> bookingList;
}
