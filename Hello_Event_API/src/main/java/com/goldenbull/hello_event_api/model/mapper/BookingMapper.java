package com.goldenbull.hello_event_api.model.mapper;

import com.goldenbull.hello_event_api.model.Booking;
import com.goldenbull.hello_event_api.model.DTO.BookingDTO;
import com.goldenbull.hello_event_api.model.Event;
import com.goldenbull.hello_event_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mappings({
            @Mapping(source = "user.userId", target = "userId"),
            @Mapping(source = "event.eventsId", target = "eventId")
    })
    BookingDTO toDTO(Booking entity);

    @Mappings({
            @Mapping(source = "userId", target = "user", qualifiedByName = "userIdToUser"),
            @Mapping(source = "eventId", target = "event", qualifiedByName = "eventIdToEvent")
    })
    Booking toEntity(BookingDTO dto);

    List<BookingDTO> toDTOList(List<Booking> entities);

    List<Booking> toEntityList(List<BookingDTO> dtos);

    @Named("userIdToUser")
    default User userIdToUser(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setUserId(userId);

        return user;
    }

    @Named("eventIdToEvent")
    default Event eventIdToEvent(Long eventId) {
        if (eventId == null) {
            return null;
        }
        Event event = new Event();
        event.setEventsId(eventId);
        return event;
    }
}
