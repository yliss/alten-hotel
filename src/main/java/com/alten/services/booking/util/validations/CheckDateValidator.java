package com.alten.services.booking.util.validations;

import com.alten.services.booking.models.Booking;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class CheckDateValidator implements ConstraintValidator<CheckDateConstraint, Booking> {
    @Override
    public void initialize(CheckDateConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Booking date, ConstraintValidatorContext constraintValidatorContext) {
        if (date.getCheckIn() == null || date.getCheckOut() == null)
            return false;



        return false;
    }
}
