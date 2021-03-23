package com.alten.services.booking.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Booking")
public class BookingEntity {
    @Id
    Long id;
    @Column
    GuestEntity guest;
    Date checkIn;
    Date checkOut;
    @Column
    StatusEntity status;
}
