package com.goldenbull.hello_event_api.model.mapper;

import com.goldenbull.hello_event_api.model.DTO.UserDTO;
import com.goldenbull.hello_event_api.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO DTO);
    UserDTO toDTO(User entity);
    List<UserDTO> toDTOList(List<User> users);
    List<User> toEntityList(List<UserDTO> userDTOs);
}

