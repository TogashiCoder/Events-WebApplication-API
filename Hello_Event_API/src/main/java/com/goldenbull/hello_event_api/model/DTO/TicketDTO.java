package com.goldenbull.hello_event_api.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TicketDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private Long userId;
    private  Long eventId;
    private  Long bookingId;
    private int quantity;
    private double price;
}
