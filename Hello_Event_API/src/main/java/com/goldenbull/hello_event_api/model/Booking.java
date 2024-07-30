package com.goldenbull.hello_event_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long bookingID;
    @Column(updatable = false)
    private LocalDateTime bookingDate;
    private int ticketsNumber;
    @PrePersist //its like hook lifecycle invoke before save this entity for the first time
    protected void onCreate() {
        bookingDate = LocalDateTime.now();
    }
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event ;
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
