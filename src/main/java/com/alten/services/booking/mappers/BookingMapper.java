package com.alten.services.booking.mappers;

import com.alten.services.booking.data.entities.BookingEntity;
import com.alten.services.booking.models.Booking;
import com.alten.services.booking.models.Guest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", qualifiedByName = "getEmail")
    @Mapping(target = "name", qualifiedByName = "getName")
    @Mapping(target = "status", ignore = true)
    BookingEntity modelToEntity(Booking booking);

    @Mapping(target = "guest", qualifiedByName = "getGuest")
    Booking entityToModel(BookingEntity booking);

    @Named("getEmail")
    static String getEmail(Booking booking) {
        if (booking != null && booking.getGuest() != null) {
            return booking.getGuest().getEmail();
        } else
            return "";
    }

    @Named("getName")
    static String getName(Booking booking) {
        if (booking != null && booking.getGuest() != null) {
            return booking.getGuest().getName();
        } else
            return "";
    }

    @Named("getGuest")
    static Guest createGuestModelObject(final BookingEntity booking) {
        Guest guest = new Guest();
        guest.setEmail(booking.getEmail());
        guest.setName(booking.getName());

        return guest;
    }
}
