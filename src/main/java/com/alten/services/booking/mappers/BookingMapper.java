package com.alten.services.booking.mappers;
import com.alten.services.booking.data.entities.BookingEntity;
import com.alten.services.booking.models.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingEntity modelToEntity (Booking booking);
}
