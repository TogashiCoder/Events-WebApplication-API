package com.goldenbull.hello_event_api.model.mapper;

import com.goldenbull.hello_event_api.model.DTO.EventDTO;
import com.goldenbull.hello_event_api.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event toEntity(EventDTO DTO);
    EventDTO toDTO(Event entity);
    List<EventDTO> toDTOList(List<Event> users);
    List<Event> toEntityList(List<EventDTO> userDTOs);


    void updateEventFromDto(EventDTO dto, @MappingTarget Event entity);


}
