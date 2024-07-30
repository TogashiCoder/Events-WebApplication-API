package com.goldenbull.hello_event_api.service;


import com.goldenbull.hello_event_api.model.DTO.EventDTO;
import com.goldenbull.hello_event_api.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    EventDTO createEvent(EventDTO event);
    List<EventDTO> getAllEvents();
    EventDTO updateEvent(EventDTO eventDTO, Long id);
    void deleteEvent(Long id);



    List<EventDTO> filterEventsByDate(LocalDate date);

    List<EventDTO> filterEventsByLocation(String location);

    List<EventDTO> filterEventsByCategory(String category);

}
