
package com.goldenbull.hello_event_api.controller;



import com.goldenbull.hello_event_api.model.DTO.EventDTO;
import com.goldenbull.hello_event_api.service.implementation.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/event")

public class EventController {
    
    @Autowired
    private EventServiceImpl eventService ;

    @PostMapping("/create")
    public EventDTO createEvent(@RequestBody EventDTO event){
        return eventService.createEvent(event);
    }

    @GetMapping("/AllEvents")
    public List<EventDTO> getAllEvents(){
        return eventService.getAllEvents();
    }

    @PutMapping("/{id}")
    public EventDTO updateEvent(@RequestBody EventDTO eventDTO, @PathVariable Long id){
        return  eventService.updateEvent(eventDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
    }


    @GetMapping("/filterByDate")
    public List<EventDTO> filterEventsByDate(@RequestParam LocalDate date) {
        return eventService.filterEventsByDate(date);
    }

    @GetMapping("/filterByLocation/{location}")
    public List<EventDTO> searchEventsByLocation(@PathVariable String location) {
        return eventService.filterEventsByLocation(location);
    }

    @GetMapping("/filterByCategory/{category}")
    public List<EventDTO> searchEventsByCategory(@PathVariable String category) {
        return eventService.filterEventsByCategory(category);
    }

}
