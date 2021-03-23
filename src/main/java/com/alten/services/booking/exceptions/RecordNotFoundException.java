package com.alten.services.booking.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RecordNotFoundException extends RuntimeException {
    private final String description;
}
