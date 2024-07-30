package com.goldenbull.hello_event_api.repository;

import com.goldenbull.hello_event_api.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
