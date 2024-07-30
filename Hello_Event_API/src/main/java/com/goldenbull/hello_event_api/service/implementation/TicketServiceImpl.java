package com.goldenbull.hello_event_api.service.implementation;


import com.goldenbull.hello_event_api.model.DTO.TicketDTO;
import com.goldenbull.hello_event_api.model.Event;
import com.goldenbull.hello_event_api.model.Ticket;
import com.goldenbull.hello_event_api.model.mapper.TicketMapper;
import com.goldenbull.hello_event_api.repository.TicketRepository;
import com.goldenbull.hello_event_api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository TicketRepository;
    @Autowired
    private TicketMapper TicketMapper;

    @Override
    public TicketDTO createTicket(TicketDTO Ticket) {
        Ticket newTicket =  TicketMapper.toEntity(Ticket);
        return TicketMapper.toDTO( TicketRepository.save(newTicket));
    }

    @Override
    public List<TicketDTO> getAllTicket() {
        List<Ticket> Tickets = TicketRepository.findAll();
        return TicketMapper.toDTOList(Tickets);
    }

    @Override
    public void deleteTicket(Long id) {
        TicketRepository.deleteById(id);
    }

    @Override
    public TicketDTO getTicketById(Long id) {
        Ticket ticket = TicketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id " + id));
        TicketDTO ticketDTO;
        return  ticketDTO = TicketMapper.toDTO(ticket);
    }

}
