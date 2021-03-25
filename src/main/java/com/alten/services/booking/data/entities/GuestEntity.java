package com.alten.services.booking.data.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Guest")
public class GuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guestIdGenerator")
    @SequenceGenerator(name = "guestIdGenerator", sequenceName = "guestId",
            allocationSize = 1,initialValue=1)
    Long id;
    @Column
    private String name;
    @Column
    private String email;
}
