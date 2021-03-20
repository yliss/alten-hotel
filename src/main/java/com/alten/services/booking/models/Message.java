package com.alten.services.booking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
    public Message(String description) {
        this.description = description;
    }

    private String code;
    private String description;
}
