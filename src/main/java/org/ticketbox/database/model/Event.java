package org.ticketbox.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

    private String location;

    private Date startTime;

    private Date endTime;

    private String backgroundImageUrl;

    @ManyToOne
    @JoinColumn(name="organizer_id")
    private Organizer organizer;

    @OneToMany
    @JoinColumn(name="event")
    private List<TicketType> ticketTypes;
}
