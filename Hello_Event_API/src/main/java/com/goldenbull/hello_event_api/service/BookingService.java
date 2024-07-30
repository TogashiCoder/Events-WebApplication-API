package com.goldenbull.hello_event_api.service;


import com.goldenbull.hello_event_api.model.DTO.BookingDTO;

import java.util.List;

public interface BookingService {

    BookingDTO createBooking(BookingDTO booking);
    List<BookingDTO> getAllBooking();

    BookingDTO getBookingById(Long id);
    void deleteBooking(Long id);
}

