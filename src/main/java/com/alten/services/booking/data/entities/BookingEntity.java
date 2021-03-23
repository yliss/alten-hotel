package com.alten.services.booking.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdGenerator")
    @SequenceGenerator(name = "bookingIdGenerator", sequenceName = "bookingId",
            allocationSize = 1,initialValue=1)
    Long id;
    @Column
    String guestId;
    @Column
    Date checkIn;
    @Column
    Date checkOut;
}
