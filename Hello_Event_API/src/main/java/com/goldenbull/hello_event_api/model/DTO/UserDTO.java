package com.goldenbull.hello_event_api.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldenbull.hello_event_api.model.Enum.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    @JsonIgnore
    private List<BookingDTO> bookingDTOS;
    @JsonIgnore
    private List<TicketDTO> ticketDTOS;
}
