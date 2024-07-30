package com.goldenbull.hello_event_api.controller;



import com.goldenbull.hello_event_api.model.DTO.TicketDTO;
import com.goldenbull.hello_event_api.service.implementation.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ticket")
public class TicketController {

    @Autowired
    private TicketServiceImpl TicketService;

    @PostMapping("/create")
    public TicketDTO createContact(@RequestBody TicketDTO Ticket){
        return TicketService.createTicket(Ticket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTickById(@PathVariable Long id) {
        TicketDTO ticketDTO = TicketService.getTicketById(id);
        return ResponseEntity.ok(ticketDTO);
    }


    @GetMapping("/AllTicket")
    public List<TicketDTO> getAllContacts(){
        return TicketService.getAllTicket();
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id){
        TicketService.deleteTicket(id);
    }

}
