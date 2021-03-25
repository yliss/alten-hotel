package com.alten.services.booking.mappers;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    import com.alten.services.booking.data.entities.BookingEntity;
import com.alten.services.booking.models.Booking;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    import com.alten.services.booking.models.Guest;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(target = "id",  ignore = true)

    @Mapping(source = "guest", target = "guest")
    BookingEntity modelToEntity (Booking booking);

    @Mapping(source = "guest", target = "guest")
    Booking entityToModel (BookingEntity booking);

  /*  @Named("getGuest")
    static String getGuest(Guest guest) {
        if (guest != null) {
            return guest.getEmail();
        } else
            return null;
    }

    @Named("getGuest")
    static Guest createGuestModelObject(final String guestId) {
        if (guestId != null) {
            Guest guest = new Guest();
            guest.setEmail(guestId);
            guest.setName();
            return guest;
        } else
            return null;
    }
*/
}
