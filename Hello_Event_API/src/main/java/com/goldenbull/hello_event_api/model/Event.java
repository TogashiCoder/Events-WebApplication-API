package com.goldenbull.hello_event_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private Long eventsId;
    private String title;
    private String description;
    private String location;
    private LocalDate date;
    private String category;
    private Double price;
    private int availableTickets;
    @OneToMany(mappedBy = "event" , cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @OneToMany(mappedBy = "event" , cascade = CascadeType.ALL)
    private List<Ticket> tickets;


}
