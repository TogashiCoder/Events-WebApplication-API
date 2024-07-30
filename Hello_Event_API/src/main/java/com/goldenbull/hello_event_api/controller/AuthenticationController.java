package com.goldenbull.hello_event_api.controller;

import com.goldenbull.hello_event_api.model.AuthenticationResponse;
import com.goldenbull.hello_event_api.model.DTO.UserDTO;
import com.goldenbull.hello_event_api.model.mapper.UserMapper;
import com.goldenbull.hello_event_api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;




    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDTO request) {

        return ResponseEntity.ok(authenticationService.register(userMapper.toEntity(request)));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody UserDTO request) {

        return ResponseEntity.ok(authenticationService.authenticate(userMapper.toEntity(request)));
    }




}





