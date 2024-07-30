package com.goldenbull.hello_event_api.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldenbull.hello_event_api.model.Booking;
import com.goldenbull.hello_event_api.model.Ticket;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EventDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long eventsId;
    private String title;
    private String description;
    private String location;
    private LocalDate date;
    private String category;
    private Double price;
    private int availableTickets;
    @JsonIgnore
    private List<Booking> booking;
    @JsonIgnore
    private List<Ticket> ticket;
}
