package org.ticketbox.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
@Builder
public class Event extends BaseModel {
    private String name;

    private String backgroundImageUrl;

    private Date startTime;

    private Date endTime;

    private String location;

    private String description;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event")
    private List<TicketType> ticketTypes;
}
