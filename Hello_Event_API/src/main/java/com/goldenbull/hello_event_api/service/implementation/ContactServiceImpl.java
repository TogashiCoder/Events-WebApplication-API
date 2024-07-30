package com.goldenbull.hello_event_api.service.implementation;


import com.goldenbull.hello_event_api.model.Contact;
import com.goldenbull.hello_event_api.model.DTO.ContactDTO;
import com.goldenbull.hello_event_api.model.mapper.ContactMapper;
import com.goldenbull.hello_event_api.repository.ContactRepository;
import com.goldenbull.hello_event_api.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository ;
    @Autowired
    private ContactMapper contactMapper;

    @Override
    public Contact createContact(ContactDTO contact) {
        ContactDTO newcontact = contact;
        return contactRepository.save(contactMapper.toEntity(newcontact));
    }

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts;
    }

    @Override
    public void deleteContact(Long id) {
    List<ContactDTO> contacts = new ArrayList<>();
    contacts.remove(id);
    }
}
