package com.goldenbull.hello_event_api.repository;

import com.goldenbull.hello_event_api.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByDate(LocalDate date);
    List<Event> findByLocation(String location);

    List<Event> findByCategory(String category);

}
