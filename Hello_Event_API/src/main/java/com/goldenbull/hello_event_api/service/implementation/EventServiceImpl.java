package com.goldenbull.hello_event_api.service.implementation;


import com.goldenbull.hello_event_api.model.DTO.EventDTO;
import com.goldenbull.hello_event_api.model.Event;
import com.goldenbull.hello_event_api.model.mapper.EventMapper;
import com.goldenbull.hello_event_api.repository.EventRepository;
import com.goldenbull.hello_event_api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventMapper eventMapper;


    @Override
    public EventDTO createEvent(EventDTO event) {
        return eventMapper.toDTO(eventRepository.save(eventMapper.toEntity(event)));
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return eventMapper.toDTOList(eventRepository.findAll());
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDTO, Long id) {
        Event event = eventRepository.findById(id).orElseThrow();
        eventMapper.updateEventFromDto(eventDTO, event);
        event.setEventsId(id);
        return eventMapper.toDTO(eventRepository.save(event));
    }


    @Override
    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }


    @Override
    public List<EventDTO> filterEventsByDate(LocalDate date) {
        List<Event> events = eventRepository.findByDate(date);
        return eventMapper.toDTOList(events);
    }

    @Override
    public List<EventDTO> filterEventsByLocation(String location) {
        return eventMapper.toDTOList(eventRepository.findByLocation(location));
    }

    @Override
    public List<EventDTO> filterEventsByCategory(String category) {
        return eventMapper.toDTOList(eventRepository.findByCategory(category));
    }

}
