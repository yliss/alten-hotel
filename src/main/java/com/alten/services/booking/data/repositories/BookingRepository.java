package com.alten.services.booking.data.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.alten.services.booking.data.entities.BookingEntity;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BookingRepository  extends CrudRepository <BookingEntity, Long>{

    @Query("SELECT b FROM BookingEntity b WHERE b.checkIn = 1")
    BookingEntity findByCheckIn(Date checkIn);
}
