package com.goldenbull.hello_event_api.service.implementation;



import com.goldenbull.hello_event_api.model.Booking;
import com.goldenbull.hello_event_api.model.DTO.BookingDTO;
import com.goldenbull.hello_event_api.model.Event;
import com.goldenbull.hello_event_api.model.User;
import com.goldenbull.hello_event_api.model.mapper.BookingMapper;
import com.goldenbull.hello_event_api.repository.BookingRepository;
import com.goldenbull.hello_event_api.repository.EventRepository;
import com.goldenbull.hello_event_api.repository.UserRepository;
import com.goldenbull.hello_event_api.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;


    @Override
    public BookingDTO createBooking(BookingDTO booking) {
        Booking newbooking =  bookingMapper.toEntity(booking);
        User user = userRepository.findById(booking.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + booking.getUserId()));
        newbooking.setUser(user);
        Event event = eventRepository.findById(booking.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + booking.getEventId()));
        newbooking.setEvent(event);
        BookingDTO bookingDTO = bookingMapper.toDTO( bookingRepository.save(newbooking));
        bookingDTO.setEventId(booking.getEventId());
        bookingDTO.setUserId(booking.getUserId());
        return bookingDTO;
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookingMapper.toDTOList(bookings);
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        BookingDTO bookingDTO = bookingRepository.findById(id)
                .map(booking -> bookingMapper.toDTO(booking))
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + id));
        return  bookingDTO;
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
