package com.goldenbull.hello_event_api.model;

import com.goldenbull.hello_event_api.model.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
