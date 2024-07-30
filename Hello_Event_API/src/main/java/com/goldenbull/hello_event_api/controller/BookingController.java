package com.goldenbull.hello_event_api.controller;



import com.goldenbull.hello_event_api.model.DTO.BookingDTO;
import com.goldenbull.hello_event_api.service.implementation.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/Booking")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;

    @PostMapping("/create")
    public BookingDTO createBooking(@RequestBody BookingDTO booking){
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        BookingDTO bookingDTO = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingDTO);
    }

    @GetMapping("/AllBooking")
    public List<BookingDTO> getAllBookings(){
        return bookingService.getAllBooking();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
    }

}
