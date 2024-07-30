package com.goldenbull.hello_event_api.model.mapper;

import com.goldenbull.hello_event_api.model.Contact;
import com.goldenbull.hello_event_api.model.DTO.ContactDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toEntity(ContactDTO DTO);
    ContactDTO toDTO(Contact entity);
    List<ContactDTO> toDTOList(List<Contact> users);
    List<Contact> toEntityList(List<ContactDTO> userDTOs);
}

