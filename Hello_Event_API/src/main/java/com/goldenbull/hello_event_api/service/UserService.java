package com.goldenbull.hello_event_api.service;


import com.goldenbull.hello_event_api.model.DTO.UserDTO;
import com.goldenbull.hello_event_api.model.User;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);

    UserDTO getUserById(long id);
    List<UserDTO> getAllUsers();
    void deleteUser(Long id);

    UserDTO updateUserById(UserDTO userDTO);
}
