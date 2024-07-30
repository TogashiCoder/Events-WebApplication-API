package com.goldenbull.hello_event_api.model.mapper;

import com.goldenbull.hello_event_api.model.DTO.TicketDTO;
import com.goldenbull.hello_event_api.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mappings({
            @Mapping(source = "userId",target = "user.userId"),
            @Mapping(source = "eventId",target = "event.eventsId"),
            @Mapping(source = "bookingId",target = "booking.bookingID")
    })
    Ticket toEntity(TicketDTO DTO);

    @Mappings({
            @Mapping(source = "user.userId",target = "userId"),
            @Mapping(source = "event.eventsId",target = "eventId"),
            @Mapping(source = "booking.bookingID",target = "bookingId")

    })
    TicketDTO toDTO(Ticket entity);

    List<TicketDTO> toDTOList(List<Ticket> transactions);
    List<Ticket> toEntityList(List<TicketDTO> userDTOs);
}

