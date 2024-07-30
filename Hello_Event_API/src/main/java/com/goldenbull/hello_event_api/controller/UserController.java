package com.goldenbull.hello_event_api.controller;



import com.goldenbull.hello_event_api.model.AuthenticationResponse;
import com.goldenbull.hello_event_api.model.DTO.UserDTO;
import com.goldenbull.hello_event_api.service.AuthenticationService;
import com.goldenbull.hello_event_api.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    private final AuthenticationService authenticationService;



    @GetMapping("/admin/All")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
         userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO,@PathVariable Long id)
    {
        ResponseEntity<UserDTO> response;
        userDTO.setUserId(id);
        UserDTO newUpdate =  userService.updateUserById(userDTO);
        if (newUpdate != null) {
            return ResponseEntity.ok(newUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
