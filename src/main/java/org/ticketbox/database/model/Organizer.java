package org.ticketbox.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="organizers")
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "organizer")
    private List<OrganizerRole> organizerRoles;

    @OneToMany(mappedBy = "organizer")
    private List<Event> events;
}
