package org.ticketbox.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event extends BaseModel {
    private String name;

    private String description;

    private String location;

    private Date startTime;

    private Date endTime;

    private String backgroundImageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="organizer_id")
    private Organizer organizer;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="event")
    private List<TicketType> ticketTypes;
}
