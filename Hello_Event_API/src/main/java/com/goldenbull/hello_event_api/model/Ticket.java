package com.goldenbull.hello_event_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickes")
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    private int quantity;
    private double price;
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;
}
