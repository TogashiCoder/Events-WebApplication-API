package com.goldenbull.hello_event_api.model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactDTO {
    private Long contactId;
    private String name ;
    private String email ;
    private String subject ;
    private String message ;
}
