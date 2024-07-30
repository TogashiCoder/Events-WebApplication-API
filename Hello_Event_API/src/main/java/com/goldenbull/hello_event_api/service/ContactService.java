package com.goldenbull.hello_event_api.service;

import com.goldenbull.hello_event_api.model.Contact;
import com.goldenbull.hello_event_api.model.DTO.ContactDTO;

import java.util.List;

public interface ContactService {

    Contact createContact(ContactDTO contact);
    List<Contact> getAllContacts();
    void deleteContact(Long id);
}
