
package com.goldenbull.hello_event_api.service;


import com.goldenbull.hello_event_api.model.DTO.TicketDTO;
import com.goldenbull.hello_event_api.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface TicketService {

    TicketDTO createTicket(TicketDTO Ticket);
    List<TicketDTO> getAllTicket();
    void deleteTicket(Long id);
    TicketDTO getTicketById(Long id);

}
