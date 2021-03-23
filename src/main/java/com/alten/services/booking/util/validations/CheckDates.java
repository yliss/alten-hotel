package com.alten.services.booking.util.validations;

import com.alten.services.booking.models.Booking;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckDateValidator.class)
@Target( { ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckDates {
    String message() default "Invalid date";
    Class<?>[] groups() default {};
    Class<? extends Booking>[] payload() default {};
}
