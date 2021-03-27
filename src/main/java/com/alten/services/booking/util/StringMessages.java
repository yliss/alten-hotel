package com.alten.services.booking.util;

public class StringMessages {
    private StringMessages() {
    }

    public static final String BOOKING_INFO_IS_REQUIRED = "The request body is required";
    public static final String BOOKING_ID_IS_REQUIRED = "The booking id is required for retrieve the data from the data base";
    public static final String BOOKING_DUPLICATE_ERROR = "The booking was not created because there is a booking with the same checkin date and checkout date";
    public static final String BOOKING_DOES_NOT_EXIST = "The booking record was not found by the id";
    public static final String CHECKIN_AND_CHECKOUT_DATES_ARE_REQUIRED = "The request body is required";
    public static final String CHECK_IN_DATE_REQUIRED = "The checkin date is required";
    public static final String CHECK_OUT_DATE_REQUIRED = "The checkin date is required";
    public static final String CHECK_OUT_DATE_BEFORE_CHECK_IN = "The checkout date can not be before the checkin date";
    public static final String BOOKING_INVALID_BY_DAYS = "The booking can not be greater than 3 days";
    public static final String BOOKING_INVALID_DATE_OUT_OF_DATE = "The checkin date is 30 days after the current date";

}
