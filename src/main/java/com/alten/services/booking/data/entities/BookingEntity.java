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
            allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(unique = true)
    private Date checkIn;

    @Column(unique = true)
    private Date checkOut;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String status;
}
