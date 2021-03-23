package com.alten.services.booking.util.validations;

import com.alten.services.booking.models.Booking;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;

public class CheckDateValidator implements ConstraintValidator<CheckDates, Booking> {
    @Override
    public void initialize(CheckDates constraintAnnotation) {

    }

    @Override
    public boolean isValid(Booking booking, ConstraintValidatorContext constraintValidatorContext) {
        if (booking.getCheckIn() == null || booking.getCheckOut() == null)
            return false;
        else {
            final LocalDate checkIn = booking.getCheckIn().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            final LocalDate checkOut = booking.getCheckOut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            final LocalDate currentDate = LocalDate.now();
            final LocalDate currentDatePlus30Days = LocalDate.now().plusDays(30);

            final long daysBetweenChecking = Duration.between(checkIn, checkOut).toDays();

            return daysBetweenChecking <= 3 &&
                    checkIn.isAfter(currentDate) &&
                    checkOut.isBefore(currentDatePlus30Days);
        }
    }
}
