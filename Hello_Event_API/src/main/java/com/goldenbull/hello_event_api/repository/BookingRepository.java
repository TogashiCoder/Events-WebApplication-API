package com.goldenbull.hello_event_api.repository;

import com.goldenbull.hello_event_api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
