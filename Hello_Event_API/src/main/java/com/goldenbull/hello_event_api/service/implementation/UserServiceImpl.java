package com.goldenbull.hello_event_api.service.implementation;


import com.goldenbull.hello_event_api.model.DTO.UserDTO;
import com.goldenbull.hello_event_api.model.mapper.UserMapper;
import com.goldenbull.hello_event_api.repository.UserRepository;
import com.goldenbull.hello_event_api.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO user) {
        System.out.println(user);
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(user))) ;
    }

    @Override
    public UserDTO getUserById(long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " not found"));
    }

    @Override
    public List<UserDTO> getAllUsers(){
        return userMapper.toDTOList(userRepository.findAll());
    }

    @Override
    public void  deleteUser(Long id){
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDTO updateUserById(UserDTO userDTO) {
        if (userDTO == null || userDTO.getUserId() == null) {
            throw new IllegalArgumentException("UserDTO or ID must not be null!");
        }
        return Optional.of(userDTO)
                .map(userMapper::toEntity)
                .map(userRepository::save)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Failed to update user"));
    }


}
