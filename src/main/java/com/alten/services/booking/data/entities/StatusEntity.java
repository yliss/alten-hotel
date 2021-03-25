package com.alten.services.booking.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Status")
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statusIdGenerator")
    @SequenceGenerator(name = "statusIdGenerator", sequenceName = "statusId",
            allocationSize = 1,initialValue=1)
    Long id;
    @Column
    private String code;
    @Column
    private String message;
}
