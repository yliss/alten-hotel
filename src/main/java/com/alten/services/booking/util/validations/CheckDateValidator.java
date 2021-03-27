package com.alten.services.booking.util.validations;

import com.alten.services.booking.models.Booking;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;

import static com.alten.services.booking.util.StringMessages.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class CheckDateValidator implements ConstraintValidator<CheckDates, Object> {
    @Override
    public void initialize(CheckDates constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        boolean bookingIsValid = false;
        String message = EMPTY;
        if (object instanceof Booking) {
            Booking booking = (Booking) object;
            if (booking.getCheckIn() == null) {
                message = CHECK_IN_DATE_REQUIRED;
            } else if (booking.getCheckOut() == null) {
                message = CHECK_OUT_DATE_REQUIRED;
            } else {
                final LocalDate checkIn = booking.getCheckIn().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                final LocalDate checkOut = booking.getCheckOut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                final LocalDate currentDate = LocalDate.now();
                final LocalDate currentDatePlus30Days = LocalDate.now().plusDays(30);

                final long daysBetweenChecking = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();

                System.out.println(checkIn.isAfter(currentDate) && checkOut.isBefore(currentDatePlus30Days));

                if (daysBetweenChecking >= 3) {
                    message = BOOKING_INVALID_BY_DAYS;
                } else if (checkOut.isBefore(checkIn)) {
                    message = CHECK_OUT_DATE_BEFORE_CHECK_IN;
                } else if (!(checkIn.isAfter(currentDate) && checkOut.isBefore(currentDatePlus30Days))) {
                    message = BOOKING_INVALID_DATE_OUT_OF_DATE;
                } else {
                    bookingIsValid = true;
                }
            }
        }

        constraintValidatorContext
                .buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
        return bookingIsValid;
    }
}
