package com.goldenbull.hello_event_api.controller;



import com.goldenbull.hello_event_api.model.Contact;
import com.goldenbull.hello_event_api.model.DTO.ContactDTO;
import com.goldenbull.hello_event_api.service.implementation.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @PostMapping("/create")
    public Contact createContact(@RequestBody ContactDTO contact){
        return contactService.createContact(contact);
    }

    @GetMapping("/AllContacts")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
    }

}
