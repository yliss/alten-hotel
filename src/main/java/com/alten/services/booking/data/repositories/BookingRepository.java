package com.alten.services.booking.data.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.alten.services.booking.data.entities.BookingEntity;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Long> {

    @Query("SELECT b FROM BookingEntity b WHERE b.checkIn = :checkInDate")
    BookingEntity findByCheckIn(Date checkInDate);

    @Query("SELECT booking FROM BookingEntity booking WHERE (:checkInDate BETWEEN booking.checkIn and booking.checkOut) or (:checkOutDate BETWEEN booking.checkIn and booking.checkOut)")
    List<BookingEntity> findByCheckDates(Date checkInDate, Date checkOutDate);

}
