package com.goldenbull.hello_event_api.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long bookingID;
    private LocalDateTime bookingDate;
    private int ticketsNumber;
    private long userId;
    private long eventId;
    @JsonIgnore
    private List<TicketDTO> tickets;
}
